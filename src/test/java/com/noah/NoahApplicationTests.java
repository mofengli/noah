package com.noah;

import com.noah.entity.*;
import com.noah.mapper.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class NoahApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProduceMapper produceMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private IndentMapper indentMapper;
	@Autowired
	private DeliveryMapper deliveryMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		customerMapper.insert("A");
		Customer customer = customerMapper.findByName("A");
		Assert.assertEquals("A",customer.getName());
		Customer customer2 = customerMapper.findById(customer.getId());
		Assert.assertEquals(customer.getId(), customer2.getId());

		produceMapper.insert("A", "1");
		Product product = produceMapper.findByName("A");
		Assert.assertEquals("A",product.getName());
		Product product2 = produceMapper.findById(product.getId());
		Assert.assertEquals("1",product.getCode());
		product2.setCode("2");
		product2.setName("B");
		produceMapper.update(product2);
		Product product3 = produceMapper.findByName("B");
		Assert.assertEquals("B",product3.getName());
		produceMapper.delete(product3.getId());
		Product product4 = produceMapper.findByName("B");
		Assert.assertEquals(null,product4);

		supplierMapper.insert("A");
		Supplier supplier = supplierMapper.findByName("A");
		Assert.assertEquals("A", supplier.getName());
		Supplier supplier2 = supplierMapper.findById(supplier.getId());
		Assert.assertEquals(supplier.getId(), supplier2.getId());

		Indent indent = new Indent();
		indent.setAmount(1000L);
		indent.setCurrency(1);
		indent.setCustomerId(2L);
		indent.setEndDate(new Date());
		indent.setExt("test1");
		indent.setProductId(3L);
		indent.setStatus(2);
		indent.setSum(3000L);
		indent.setStartDate(new Date());
		indentMapper.insert(indent);
		Indent indent2 = indentMapper.findByProductId(3L);
		Assert.assertEquals("test1", indent2.getExt());

		List<Indent> indents = indentMapper.findAll();
		System.out.println("**********len:" + indents.size());
		for (Indent i : indents) {
			System.out.println("**********CustomerId:" +i.getCustomerId());
		}


		Delivery delivery = new Delivery();
		delivery.setAmount(1000L);
		delivery.setIndentId(001L);
		delivery.setReceiver("a");
		delivery.setSender("b");
		deliveryMapper.insert(delivery);
		Delivery delivery2 = deliveryMapper.findByIndentId(0001L);
		Assert.assertEquals("a", delivery2.getReceiver());
	}

}

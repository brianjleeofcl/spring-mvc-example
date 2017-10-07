package net.brianjlee.springExample;

import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {
    @Test
    public void PhoneNumberInstantiates() {
        try {
            PhoneNumber phone = new PhoneNumber();
            phone.setNumber("1111111111");
            Assert.assertTrue(phone instanceof PhoneNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PhoneNumberReturnsString() {
        try {
            PhoneNumber phone = new PhoneNumber();
            phone.setNumber("1111111111");
            Assert.assertEquals(phone.getNumber(), "111-111-1111");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PhoneNumberReturnsFormattedString() {
        try {
            PhoneNumber phone = new PhoneNumber();
            PhoneNumber phone2 = new PhoneNumber();
            phone.setNumber("111-111-1111");
            phone2.setNumber("123-123-1234");
            Assert.assertEquals("(111) 111-1111", phone.getFormattedNumber());
            Assert.assertEquals("(123) 123-1234", phone2.getFormattedNumber());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PhoneNumberReturnsShortString() {
        try {
            PhoneNumber phone = new PhoneNumber();
            phone.setNumber("111-111-1111");
            Assert.assertEquals("1111111111", phone.getShortNumber());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

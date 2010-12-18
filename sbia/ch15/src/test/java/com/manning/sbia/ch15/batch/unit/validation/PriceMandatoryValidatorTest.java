/**
 *
 */
package com.manning.sbia.ch15.batch.unit.validation;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.validator.ValidationException;

import com.manning.sbia.ch15.batch.validation.PriceMandatoryValidator;
import com.manning.sbia.ch15.domain.Product;

/**
 * Unit test.
 *
 * @author bazoud
 *
 */
public class PriceMandatoryValidatorTest {
  private PriceMandatoryValidator validator;
  private Product product;

  @Before
  public void setUp() {
    validator = new PriceMandatoryValidator();
    product = new Product();
  }

  @Test
  public void validate() {
    product.setPrice(new BigDecimal("100.0"));
    validator.validate(product);
  }

  @Test(expected = ValidationException.class)
  public void notValidate() {
    validator.validate(product);
  }
}

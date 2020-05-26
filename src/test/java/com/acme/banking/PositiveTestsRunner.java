package com.acme.banking;

import com.acme.banking.dbo.ClientTest;
import com.acme.banking.dbo.SavingAccountTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({PositiveTest.class})
@Suite.SuiteClasses({ClientTest.class, SavingAccountTest.class})
public class PositiveTestsRunner {

}

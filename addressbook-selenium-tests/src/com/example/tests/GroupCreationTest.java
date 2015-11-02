package com.example.tests;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTest  extends TestBase{
    
	
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	  app.getNavigationHelper().openMainPage();
      app.getNavigationHelper().gotoGroupPage();
      
      // save old state
       List<GroupData> oldList = app.getGroupHelper().getGroups();
      // actions
      app.getGroupHelper().initGroupCreation();

	app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returnToGroupPage();
   // save new sate
      List<GroupData> newList = app.getGroupHelper().getGroups();
     // compare states
  
      oldList.add(group);
      Collections.sort(oldList);
      assertEquals(newList, oldList);
  }
  
}
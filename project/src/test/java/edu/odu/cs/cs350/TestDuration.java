

package edu.odu.cs.cs350;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





/**
 *  Unit test for Duration.
 *  Set up any required parameters.
 *	Call the mutator function that you want to test, using those parameters.
 *	Check the outputs of each accessor function with appropriate assertions
 */
public class TestDuration {

	
	/*
	 * Mutators:
	 * Duration()
	 * Duration(long totalSeconds)
	 * Duration(int days, int hours, int minutes, int seconds) 
	 * add
	 * subtract
	 * setTotalSeconds()
	 * scale
	 * 
	 * Accesors:
	 * getTotalSeconds()
	 * getDays
	 * getHours
	 * getMinutes
	 * getSeconds
	 * toString
	 * equals
	 * hashCode
	 * clone
	 * 
	 * */
	int totalSeconds1;
	int totalSeconds2;	
	int secondsPerMinute;
	int secondsPerHour;
	int secondsPerDay; 
	int days1;
	int hours1;
	int minutes1;
	int seconds1;
	int days2;
	int hours2;
	int minutes2;
	int seconds2;
	
	int resultDays;
	int resultHours;
	int resultMinutes;
	int resultSeconds;
	
	
	Duration firstDur;
	Duration secondDur;
	Duration resultDur;
	
	
	void setup(int A, int B) {
		totalSeconds1 = A;
		totalSeconds2 = B;	
		secondsPerMinute = 60;
		secondsPerHour = 60*60;
		secondsPerDay = 60*60*24; 
		days1 = totalSeconds1/secondsPerDay;
		hours1 = (totalSeconds1%secondsPerDay)/secondsPerHour;
		minutes1 = (totalSeconds1%secondsPerHour)/secondsPerMinute;
		seconds1 = totalSeconds1%secondsPerMinute;
		days2 = totalSeconds2/secondsPerDay;
		hours2 = (totalSeconds2%secondsPerDay)/secondsPerHour;
		minutes2 = (totalSeconds2%secondsPerHour)/secondsPerMinute;
		seconds2 = totalSeconds2%secondsPerMinute;
		
		firstDur = new Duration(days1, hours1, minutes1, seconds1);
	
		secondDur = new Duration(days2, hours2, minutes2, seconds2);
	}
	/*
	@Test
	void test1() {
		Duration testDur = new Duration();
		
		assertEquals(testDur.getTotalSeconds(), 0);
		assertEquals(testDur.getDays(), 0);
		assertEquals(testDur.getHours(), 0);
		assertEquals(testDur.getMinutes(), 0);
		assertEquals(testDur.getSeconds(), 0);
		assertEquals(testDur.toString(), "00:00");
		assertTrue(testDur.equals(new Duration(0, 0, 0, 0)));
		
	}
	
	@Test
	void test2() {
		Duration testDur = new Duration(93784);
		
		assertEquals(testDur.getTotalSeconds(), 93784);
		assertEquals(testDur.getDays(), 1);
		assertEquals(testDur.getHours(), 2);
		assertEquals(testDur.getMinutes(), 3);
		assertEquals(testDur.getSeconds(), 4);
		assertEquals(testDur.toString(), "1:02:03:04");
		assertTrue(testDur.equals(new Duration(93784)));
	}
	
	@Test
	void test3() {
		Duration testDur = new Duration(615965);
		
		assertEquals(testDur.getTotalSeconds(), 615965);
		assertEquals(testDur.getDays(), 7);
		assertEquals(testDur.getHours(), 3);
		assertEquals(testDur.getMinutes(), 6);
		assertEquals(testDur.getSeconds(), 5);
		assertEquals(testDur.toString(), "7:03:06:05");
		assertTrue(testDur.equals(new Duration(615965)));
	}
	
	@Test
	void test4() {
		Duration testDur = new Duration(21, 6, 49, 38);
		
		assertEquals(testDur.getTotalSeconds(), 1838978);
		assertEquals(testDur.getDays(), 21);
		assertEquals(testDur.getHours(), 6);
		assertEquals(testDur.getMinutes(), 49);
		assertEquals(testDur.getSeconds(), 38);
		assertEquals(testDur.toString(), "21:06:49:38");
		assertTrue(testDur.equals(new Duration(1838978)));
	}
	
	@Test
	void test5() {
		Duration testDur = new Duration(1, 23, 59, 59);
		
		testDur.add(new Duration(1));
		
		assertEquals(testDur.getTotalSeconds(), 172800);
		assertEquals(testDur.getDays(), 2);
		assertEquals(testDur.getHours(), 0);
		assertEquals(testDur.getMinutes(), 0);
		assertEquals(testDur.getSeconds(), 0);
		assertEquals(testDur.toString(), "2:00:00:00");
		assertTrue(testDur.equals(new Duration(172800)));
	}
	
	@Test
	void test6() {
		Duration testDur = new Duration(18, 45, 52, 26);
		
		testDur.subtract(new Duration(-1, -39, -82, 93));
		
		assertEquals(testDur.getTotalSeconds(), 1951973);
		assertEquals(testDur.getDays(), 22);
		assertEquals(testDur.getHours(), 14);
		assertEquals(testDur.getMinutes(), 12);
		assertEquals(testDur.getSeconds(), 53);
		assertEquals(testDur.toString(), "22:14:12:53");
		assertTrue(testDur.equals(new Duration(1951973)));
	}
	*/
	/*@Test
		public final void easyPass1() {
 	 	assertEquals(1,1);
	}
	@Test
		public final void easyPass3() {
 	 	assertEquals(1,1);
	}
	@Test
	public final void easyPass2() {
	  assertEquals(1,1);
}*/	
	void setResult(int totalSeconds) {
		secondsPerMinute =  60;
		secondsPerHour = 60*60;
		secondsPerDay = 60*60*24; 
		resultDays = totalSeconds/secondsPerDay;
		resultHours = (totalSeconds%secondsPerDay)/secondsPerHour;
		resultMinutes = (totalSeconds%secondsPerHour)/secondsPerMinute;
		resultSeconds = totalSeconds%secondsPerMinute;
	}
	
	
  @Test
  public final void testEmptyConstructor() {
	Duration duration = new Duration();
	Duration duration2 = new Duration(0);
	
	assertEquals(duration.getTotalSeconds(), 0);
	assertEquals(duration.getDays(), 0);
	assertEquals(duration.getHours(), 0);
	assertEquals(duration.getMinutes(), 0);
	assertEquals(duration.getSeconds(), 0);
	assertTrue(duration.equals(duration2));
	assertEquals(duration.hashCode(), duration2.hashCode());
	duration2 = (Duration) duration.clone();
	assertTrue(duration.equals(duration2));

  }
 
  @Test
  public final void testSecondsConstructorZero() {
	Duration firstDur = new Duration(0);
	Duration secondDur = new Duration(0);
	
	assertEquals(firstDur.getTotalSeconds(), 0);
	assertEquals(firstDur.getDays(), 0);
	assertEquals(firstDur.getHours(), 0);
	assertEquals(firstDur.getMinutes(), 0);
	assertEquals(firstDur.getSeconds(), 0);
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.hashCode(), secondDur.hashCode());
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));

  }
  
  @Test
  public final void testSecondsConstructor() {
	setup(90061, 0);
	Duration firstDur = new Duration(90061);
	Duration secondDur = new Duration(1);
			
	assertEquals(firstDur.getTotalSeconds(), 90061);
	assertEquals(firstDur.getDays(), days1);
	assertEquals(firstDur.getHours(), hours1);
	assertEquals(firstDur.getMinutes(), minutes1);
	assertEquals(firstDur.getSeconds(), seconds1);
	assertFalse(firstDur.equals(secondDur));
	 assertEquals(firstDur.hashCode(), 90061);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "1:01:01:01");

  }
  
  @Test
  
  public final void testCompleteConstructorZero() {
	
	setup(0, 0);
	
	
	assertEquals(firstDur.getTotalSeconds(), totalSeconds1);
	assertEquals(firstDur.getDays(), days1);
	assertEquals(firstDur.getHours(), hours1);
	assertEquals(firstDur.getMinutes(), minutes1);
	assertEquals(firstDur.getSeconds(), seconds1);
	assertTrue(firstDur.equals(secondDur));
	 assertThat(firstDur.hashCode(), equalTo(secondDur.hashCode()));
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "00:00");

  }
  
  @Test
  public final void testCompleteConstructor() {
	
	setup(303, 0);
	firstDur = new Duration(0, 0, 5, 3);
	secondDur = new Duration(0, 0, 0, 0);
	assertEquals(firstDur.getTotalSeconds(), 303);
	assertEquals(firstDur.getDays(), days1);
	assertEquals(firstDur.getHours(), hours1);
	assertEquals(firstDur.getMinutes(), minutes1);
	assertEquals(firstDur.getSeconds(), seconds1);
	assertFalse(firstDur.equals(secondDur));
	 assertThat(firstDur.hashCode(), not(equalTo(secondDur.hashCode())));
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "05:03");

  }
  
  @Test
  public final void testSetTotalSeconds() {
	
	setup(39740, 39740);
	
	firstDur.setTotalSeconds(913746);
	
	
	assertNotEquals(firstDur.getTotalSeconds(), secondDur.getTotalSeconds());
	assertNotEquals(firstDur.getDays(), secondDur.getDays());
	assertNotEquals(firstDur.getHours(), secondDur.getHours());
	assertNotEquals(firstDur.getMinutes(), secondDur.getMinutes());
	assertNotEquals(firstDur.getSeconds(), secondDur.getSeconds());
	assertFalse(firstDur.equals(secondDur));
	 assertThat(firstDur.hashCode(), not(equalTo(secondDur.hashCode())));
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "10:13:49:06");

  }
  
  @Test
  public final void testSetTotalSeconds2() {
	
	setup(39740, 539740);
	
	firstDur.setTotalSeconds(49746);
	
	
	assertNotEquals(firstDur.getTotalSeconds(), secondDur.getTotalSeconds());
	assertNotEquals(firstDur.getDays(), secondDur.getDays());
	assertNotEquals(firstDur.getHours(), secondDur.getHours());
	assertNotEquals(firstDur.getMinutes(), secondDur.getMinutes());
	assertNotEquals(firstDur.getSeconds(), secondDur.getSeconds());
	assertFalse(firstDur.equals(secondDur));
	 assertThat(firstDur.hashCode(), not(equalTo(secondDur.hashCode())));
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "13:49:06");

  }
  
  @Test
  public final void testAddPositivePlusPositive() {
	setup(3781964, 3891047);
	setResult(3781964+3891047);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 3781964+3891047);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 7673011);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "88:19:23:31");

  }

  @Test
  public final void testAddPositivePlusNegativeAboveZero() {
	setup(938274, -38274);
	setResult(938274-38274);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274-38274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 900000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "10:10:00:00");

  }
  
  @Test
  public final void testAddPositivePlusNegativeAtZero() {
	setup(938274, -938274);
	setResult(0);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 0);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 0);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "00:00");

  }
  
  @Test
  public final void testAddPositivePlusNegativeBelowZero() {
	setup(938274, -7938274);
	setResult(938274-7938274);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274-7938274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -7000000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-81:00:26:40");

  }
  
  @Test
  public final void testAddNegativePlusPositiveAboveZero() {
	setup(-938274, 7938274);
	setResult(-938274+7938274);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), -938274+7938274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 7000000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "81:00:26:40");

  }
  
  @Test
  public final void testAddNegativePlusPositiveAtZero() {
	setup(-938274, 938274);
	setResult(0);
	resultDur = new Duration(0);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 0);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 0);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "00:00");

  }
  
  @Test
  public final void testAddNegativePlusPositiveBelowZero() {
	setup(-938274, 8274);
	setResult(-938274+8274);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), -938274+8274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -930000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(),"-10:18:20:00");

  }
  
  @Test
  public final void testAddNegativePlusNegative() {
	setup(-938274, -8274);
	setResult(-938274-8274);
	resultDur = new Duration(totalSeconds1+totalSeconds2);
	
	firstDur.add(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), -938274-8274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -946548);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-10:22:55:48");

  }
  
  @Test
  public final void testSubtractPositiveMinusPositiveAboveZero() {
	setup(938274, 38274);
	setResult(938274-38274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274-38274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 900000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "10:10:00:00");

  }
  
  @Test
  public final void testSubtractPositiveMinusPositiveAtZero() {
	setup(938274, 938274);
	setResult(938274-938274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274-938274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 0);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "00:00");

  }
  
  @Test
  public final void testSubtractPositiveMinusPositiveBelowZero() {
	setup(938274, 7938274);
	setResult(938274-7938274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274-7938274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -7000000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-81:00:26:40");

  }
  
  @Test
  public final void testSubtractPositiveMinusNegative() {
	setup(938274, -7938274);
	setResult(938274+7938274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 938274+7938274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 8876548);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "102:17:42:28");

  }
  
  @Test
  public final void testSubtractNegativeMinusNegativeBelowZero() {
	setup(-938274, -8274);
	setResult(-938274+8274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), -938274+8274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -930000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-10:18:20:00");

  }
  
  @Test
  public final void testSubtractNegativeMinusNegativeAtZero() {
	setup(-938274, -938274);
	setResult(0);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), 0);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 0);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "00:00");

  }
  
  @Test
  public final void testSubtractNegativeMinusNegativeAboveZero() {
	setup(-8274, -458274);
	setResult(-8274+458274);
	resultDur = new Duration(totalSeconds1-totalSeconds2);
	
	firstDur.subtract(secondDur);
	
	assertEquals(firstDur.getTotalSeconds(), -8274+458274);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 450000);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "5:05:00:00");

  }
  
  @Test
  public final void testScalePositiveByPositiveInteger() {
	int scaleFactor = 4;
	setup(938274, 8274);
	setResult(938274*scaleFactor);
	resultDur = new Duration(totalSeconds1*scaleFactor);
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), 938274*scaleFactor);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 3753096);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "43:10:31:36");

  }
  
  @Test
  public final void testScalePositiveByPositiveDouble() {
	double scaleFactor = 5.381;
	setup(938274, 8274);
	setResult((int)(938274*scaleFactor));
	resultDur = new Duration((int)(totalSeconds1*scaleFactor));
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), (int)(938274*scaleFactor));
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 5048852);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "58:10:27:32");

  }
  
  
  @Test
  public final void testScalePositiveByNegativeInteger() {
	int scaleFactor = -4;
	setup(938274, 8274);
	setResult(938274*scaleFactor);
	resultDur = new Duration(totalSeconds1*scaleFactor);
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), 938274*scaleFactor);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -3753096);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-43:10:31:36");

  }
  
  @Test
  public final void testScalePositiveByNegativeDouble() {
	double scaleFactor = -5.381;
	setup(938274, 8274);
	setResult((int)(938274*scaleFactor));
	resultDur = new Duration((int)(totalSeconds1*scaleFactor));
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), (int)(938274*scaleFactor));
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -5048852);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-58:10:27:32");

  }
  
  @Test
  public final void testScaleNegativeByPositiveInteger() {
	int scaleFactor = 4;
	setup(-38274, 8274);
	setResult(-38274*scaleFactor);
	resultDur = new Duration(totalSeconds1*scaleFactor);
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), -38274*scaleFactor);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -153096);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-1:18:31:36");

  }
  
  @Test
  public final void testScaleNegativeByPositiveDouble() {
	double scaleFactor = 5.381;
	setup(-98274, 8274);
	setResult((int)(-98274*scaleFactor));
	resultDur = new Duration((int)(totalSeconds1*scaleFactor));
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), (int)(-98274*scaleFactor));
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), -528812);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "-6:02:53:32");

  }
  
  
  @Test
  public final void testScaleNegativeByNegativeInteger() {
	int scaleFactor = -4;
	setup(-938274, 8274);
	setResult(-938274*scaleFactor);
	resultDur = new Duration(totalSeconds1*scaleFactor);
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), -938274*scaleFactor);
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	 assertEquals(firstDur.hashCode(), 3753096);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "43:10:31:36");

  }
  
  @Test
  public final void testScaleNegativeByNegativeDouble() {
	double scaleFactor = -5.381;
	setup(-8274, 8274);
	setResult((int)(-8274*scaleFactor));
	resultDur = new Duration((int)(totalSeconds1*scaleFactor));
	
	firstDur.scale(scaleFactor);
	
	assertEquals(firstDur.getTotalSeconds(), (int)(-8274*scaleFactor));
	assertEquals(firstDur.getDays(), resultDays);
	assertEquals(firstDur.getHours(), resultHours);
	assertEquals(firstDur.getMinutes(), resultMinutes);
	assertEquals(firstDur.getSeconds(), resultSeconds);
	assertTrue(firstDur.equals(resultDur));
	assertEquals(firstDur.hashCode(), 44522);
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));
	assertEquals(firstDur.toString(), "12:22:02");

  }
  
  @Test
  public final void testClone() {
	
	setup(39740, 387946);
	
	secondDur = (Duration)firstDur.clone();
	
	firstDur.add(new Duration(100000));
	
	
	assertNotEquals(firstDur.getTotalSeconds(), secondDur.getTotalSeconds());
	assertNotEquals(firstDur.getDays(), secondDur.getDays());
	assertNotEquals(firstDur.getHours(), secondDur.getHours());
	assertNotEquals(firstDur.getMinutes(), secondDur.getMinutes());
	assertNotEquals(firstDur.getSeconds(), secondDur.getSeconds());
	assertFalse(firstDur.equals(secondDur));
	 assertThat(firstDur.hashCode(), not(equalTo(secondDur.hashCode())));
	assertNotEquals(firstDur.toString(), secondDur.toString());
	secondDur = (Duration) firstDur.clone();
	assertTrue(firstDur.equals(secondDur));

  }
  
}

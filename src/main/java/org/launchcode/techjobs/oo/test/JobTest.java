package org.launchcode.techjobs.oo.test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

@Test
public void testSettingJobId() {
    Job job1 = new Job();
    Job job2 = new Job();
    assertNotEquals(job1, job2);
}

@Test
public void testJobConstructorSetsAllFields() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job1.getName() instanceof String);
    assertTrue(job1.getEmployer() instanceof Employer);
    assertTrue(job1.getLocation() instanceof Location);
    assertTrue(job1.getPositionType() instanceof PositionType);
    assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Product tester", job1.getName());
    assertEquals("ACME", job1.getEmployer().getValue());
    assertEquals("Desert", job1.getLocation().getValue());
    assertEquals("Quality control", job1.getPositionType().getValue());
    assertEquals("Persistence", job1.getCoreCompetency().getValue());
}

@Test
public void testJobsForEquality() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertNotEquals(job1, job2);
    assertEquals(false, job1.equals(job2));
}

@Test
public void testToStringStartsAndEndsWithNewLine() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    System.out.println(job1.toString());
    assertEquals('\n',job1.toString().charAt(0));
    assertEquals('\n',job1.toString().charAt(job1.toString().length()-1));
}

@Test
public void testToStringContainsCorrectLabelsAndData() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job1.toString().contains("Name"));
    assertTrue(job1.toString().contains(job1.getName()));
    assertTrue(job1.toString().contains("Employer"));
    assertTrue(job1.toString().contains(job1.getEmployer().getValue()));
    assertTrue(job1.toString().contains("Location"));
    assertTrue(job1.toString().contains(job1.getLocation().getValue()));
    assertTrue(job1.toString().contains("Position Type"));
    assertTrue(job1.toString().contains(job1.getPositionType().getValue()));
    assertTrue(job1.toString().contains("Core Competency"));
    assertTrue(job1.toString().contains(job1.getCoreCompetency().getValue()));
}

@Test
public void testToStringHandlesEmptyField() {
    Job job1 = new Job("", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("Data not available",job1.getEmployer().toString());
    assertEquals("Data not available",job1.getName());
}

}


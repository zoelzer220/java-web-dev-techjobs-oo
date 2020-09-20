package org.launchcode.techjobs_oo.Tests;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;


// import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class JobTests {

//    @Before
//    public static void initializeJobs() {
//        Job jobOne = new Job();
//        Job jobTwo = new Job();
//    }

    @Test
    public void testSettingJobId() { //tests empty constructor to ensure IDs are one apart
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertEquals((jobOne.getId() + 1), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() { //tests full constructor
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() { //tests that to jobs with different id numbers are not equal
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse((jobOne.equals(jobTwo)));
        assertFalse(jobOne.getId() == jobTwo.getId()); //just double checking, unnecessary

    }





}

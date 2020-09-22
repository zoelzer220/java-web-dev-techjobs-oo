package org.launchcode.techjobs_oo.Tests;

import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class JobTests {

    @Before
    public void initializeJobs() {
       Job jobOne = new Job();
       Job jobTwo = new Job();
    }

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

    @Test
    public void testJobPrintoutBlankline() { //tests the beginning and end of job object string using toString
       Job jobOne = new Job();
       char beginning = jobOne.toString().charAt(0);
       char end = jobOne.toString().charAt(jobOne.toString().length()-1);
       assertTrue(beginning == end);
    }

//    @Test
//    public void testJobPrintoutLabels() { //checks that each printout has a label for each field followed by data
//        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        // assertTrue data is own line
//        // assertTrue string has label for each field
//        // assertTrue data is after label
//        assertEquals("-", jobOne.toString());
//    }

    @Test
    public void testEmptyJob() { //tests that a job with only an id spits back an error message
        Job jobOne = new Job();
        String emptyJobTest = jobOne.toString();
        String errorMessage = "\n OOPS! This job does not seem to exist. \n";
        assertTrue(emptyJobTest == errorMessage);

    }

}

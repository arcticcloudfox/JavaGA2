package org.launchcode.techjobs.oo;

import org.junit.Test;

import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {
        //TODO: Create your unit tests here
        @Test
        public void testSettingJobId() {
            Job test1 = new Job();
            Job test2 = new Job();
            assertNotEquals(test1.getId(), test2.getId());
        }

        @Test
        public void testJobConstructorSetsAllFields() {
            Job test3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertTrue(test3.getName() instanceof String);
            assertTrue(test3.getEmployer() instanceof Employer);
            assertTrue(test3.getLocation() instanceof Location);
            assertTrue(test3.getPositionType() instanceof PositionType);
            assertTrue(test3.getCoreCompetency() instanceof CoreCompetency);

            assertEquals("Product Tester", test3.getName());
            assertEquals("ACME", test3.getEmployer().getValue());
            assertEquals("Desert", test3.getLocation().getValue());
            assertEquals("Quality control", test3.getPositionType().getValue());
            assertEquals("Persistence", test3.getCoreCompetency().getValue());
        }

        @Test
        public void testJobsForEquality() {
            Job test4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

            Job test5 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

            assertFalse(test4.equals(test5));
        }

        @Test
        public void testToStringStartsAndEndsWithNewLine() {
            Job test6 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String separator = System.lineSeparator();
            String expected = separator + "ID: " + test6.getId() + separator +
                    "Name: " + test6.getName() + separator +
                    "Employer: " + test6.getEmployer() + separator +
                    "Location: " + test6.getLocation() + separator +
                    "Position Type: " + test6.getPositionType() + separator +
                    "Core Competency: " + test6.getCoreCompetency() + separator;
            assertEquals(expected, test6.toString());
        }

        @Test
        public void testToStringContainsCorrectLabelsAndData() {
            Job test7 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String separator = System.lineSeparator();

            assertEquals(separator + "ID: " + test7.getId() + separator + "Name: Product Tester" + separator + "Employer: ACME" +
                    separator + "Location: Desert" + separator + "Position Type: Quality control" + separator + "Core Competency: Persistence" + separator, test7.toString());
        }

        @Test
        public void testToStringHandlesEmptyField() {
            Job test8 = new Job("Product Tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String separator = System.lineSeparator();

            assertEquals(separator + "ID: " + test8.getId() + separator + "Name: Product Tester" + separator + "Employer: ACME" +
                    separator + "Location: Data not available" + separator + "Position Type: Quality control" + separator + "Core Competency: Persistence" + separator, test8.toString());

        }
    }

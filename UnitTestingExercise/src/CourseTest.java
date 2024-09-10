import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	@Test
	public void testGetNumAssignmentsLegal() {
		
		// Set up
		int numAssignments = 3;
		Course c = new Course (numAssignments);
		// Method Execution
		int assignments = c.getNumAssignments();
		
		// Verification
		if (assignments != numAssignments)
		fail("Created c with " + numAssignments + " assignments, got " + assignments + 
				" assignments back");
		
	
	}
	@Test
	public void testGetNumAssignmentsIllegal() {
		
		// Set up
		int numAssignments = 0;
		Course c = new Course (numAssignments);
		// Method Execution
		int assignments = c.getNumAssignments();
		
		// Verification
		if (assignments != 1)
		fail("Checked with 0, did not get a 1 back");
		
	
	}
	@Test
	public void testAddStudent() {
		
		// Set up
		int numAssignments = 3;
		Course c = new Course (numAssignments);
		
		// Method Execution
		boolean result = c.addStudent("Jerry");
		
		// Verification
		if (result != true) {
			fail("Student was not added");
		}
		result = c.isStudentEnrolled("Jerry");
		if (result != true ) {
			fail("Student was not enrolled");
		}
		result = c.addStudent("Jerry");
		if (result != false) {
			fail("Student was added twice");
		}
		
	}
	
	
	@Test
	public void testRemoveStudent() {
		
		// Set up
		int numAssignments = 3;
		Course c = new Course (numAssignments);
		boolean result = c.addStudent("Jerry");
		
		// Method Execution
		result = c.removeStudent("Jerry");
		
		// Verification
		if (result != true) {
			fail("Student was not removed");
		}
		
		result = c.isStudentEnrolled("Jerry");
		if (result != false) {
			fail("Student was enrolled");
		}
		if (result != false) {
			fail("Student was removed twice");
		}
		
		
	}
	@Test
	public void testStudentAssignmentGradeLegal() {
		
		// Set up
		int numAssignments = 3;
		Course c = new Course(numAssignments);
		boolean result = c.addStudent("Jerry");
		
		
		
		// Method Execution
		result = c.isStudentEnrolled("Jerry");
		result = c.setStudentAssignmentGrade(2, 50, "Jerry");
		int grade = c.getStudentAssignmentGrade(2, "Jerry");
		
		// Verification
		if (result != true) {
			fail("Grade could not be set");
		}
		if (grade != 50) {
			fail("Grade is not 50");
		}
	}
		@Test
		public void testStudentAssignmentGradeIllegalAssignmentNumber() {
			
			// Set up
			int numAssignments = 3;
			Course c = new Course(numAssignments);
			boolean result = c.addStudent("Jerry");
			
			// Method Execution
			result = c.setStudentAssignmentGrade(6, 50, "Jerry");
			result = c.setStudentAssignmentGrade(0, 50, "Jerry");
			
			// Verification
			if (result != false) {
				fail("Illegal Assignment Number");
		}
			if (result != false) {
				fail("Illegal Assignment Number");
			}
		}
		@Test
		public void testStudentAssignmentGradeIllegalGrade() {
			
			// Set up
			int numAssignments = 3;
			Course c = new Course(numAssignments);
			boolean result = c.addStudent("Jerry");
			
			// Method Execution
			result = c.setStudentAssignmentGrade(2, -1, "Jerry");
			
			// Verification
			if (result != false) {
				fail("Grade is outside of 0-100 scale");
			}
		}
		@Test
		public void testifStudentisEnrolled() {
			// Set up
			int numAssignments = 3;
			Course c = new Course(numAssignments);
			boolean result = c.addStudent("Jerry");
			
			// Method Execution
			result = c.setStudentAssignmentGrade(2, 60, "Jeff");
			
			// Verification
			if (result != false) {
				fail("Student is not enrolled");
			}
		}
}

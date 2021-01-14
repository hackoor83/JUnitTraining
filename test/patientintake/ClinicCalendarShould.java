package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarShould {

    @Test
    public void allowEntryOfAnAppointment(){
        //Setup:
        /**
         * Here we create an instance of the class we are testing. In this case, ClinicCalenar.
         */
        ClinicCalendar calendar = new ClinicCalendar();

        //Execute
        /**
         * Here we call (i.e. execute) the function of interest to test (in this case addAppointment)
         * and supply this function with paramaters. We will check on whether our app is indeed adding an appointment
         * or not. So first, we add an appointment by executing the addAppointment function.
         */
        calendar.addAppointment("jim", "weaver", "avery", "09/01/2018 02:00 PM");
        /**
         * Then we create a new variable of type List of PatientAppointments. This variable is referring
         * to the actual list of appointments in the ClinicCalendar class.
         */
        List<PatientAppointment> appointments = calendar.getAppointments();

        //Verify
        /**
         * Once the above function is executed, we assume that the appointment should have been added to the List.
         * So here we will verify if this is the case.
         * So in case the appointment was successfully added, that means that the list of appointments should not be null.
         * This is what we check by the assertNotNull(appointments) function:
         */
        assertNotNull(appointments);
        /**
         * If the appointment was not added, then the list will be null indeed. Accordingly, the test will fail immidiately
         * after the assertNotNull(appointments) function.
         * But if the appointment was added successfully, that means that the list is not null. So the assertNotNull will pass.
         * Then we will check on whether the appointment has been added only once (i.e. not abnormally doublicating it).
         * We do this by assertEquals() function. This function takes two parameters. The first one is the expected value,
         * the second parameter is the actual value. So here we are expecting that the size of the list to be 1, because
         * we have added only one appointment. Then we call the actual value to compare the 1 with. So the size of the list of
         * appointments, i.e. appointments.size() should equal to 1.
         * If this is the case, the test will pass and continue to the next assertion test, otherwise will fail and exit.
         */
        assertEquals(1, appointments.size());

        /**
         * Now we will test every field of the entered appointment. First we call the first element of the List (which
         * is actually the appointment that we have just added), and save it to a variable enteredAppt.
         */
        PatientAppointment enteredAppt = appointments.get(0);

        /**
         * Now we execute the equals assertion, assertEquals, and giving the first parameter, and the second one.
         * To test the first name of the patient, we supply the assertEquals with the EXACT string value which we have
         * supplied earlier in the calendar.addAppointment(...) function. Then we call the getPatientFirstName() function in
         * the second parameter.
         * So in case the appointment has been added correctly, then the expected first name should match the saved first name.
         * The same applies to the Last Name, Doctor name, and the time date.
         */
        assertEquals("jim", enteredAppt.getPatientFirstName());
        assertEquals("weaver", enteredAppt.getPatientLastName());
        assertEquals(Doctor.avery, enteredAppt.getDoctor());
        assertEquals("9/1/2018 02:00 PM",
                enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
    }

}
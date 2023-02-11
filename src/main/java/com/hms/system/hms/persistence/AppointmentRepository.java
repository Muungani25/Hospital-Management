package com.hms.system.hms.persistence;

import com.hms.system.hms.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findAppointmentByAssignedDoctor_Id(Long doctorId);
}

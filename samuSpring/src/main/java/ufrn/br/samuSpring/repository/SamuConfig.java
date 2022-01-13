package ufrn.br.samuSpring.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import ufrn.br.samuSpring.model.Ambulancia;

public class SamuConfig {
	@Bean
	CommandLineRunner commandLineRunner(SamuRepository repository) {
		return args -> {
						
			Ambulancia ambulancia1 = new Ambulancia(
				Long.valueOf(54321),
				-6.9764,
				-43.5591,
				"ABC-1234",
				"Ranna Raabe",
				Long.valueOf(0000001),
				"RN",
				LocalDate.of(2021, Month.NOVEMBER, 19),
				Long.valueOf(1)
			);
			
			Ambulancia ambulancia2 = new Ambulancia(				
				Long.valueOf(12345),
				-5.8783,
				-35.2094,
				"DEF-4567",
				"Hannah Montana",
				Long.valueOf(0000001),
				"RN",
				LocalDate.of(2021, Month.NOVEMBER, 19),
				Long.valueOf(1)
			);
			
			repository.saveAll(
				List.of(ambulancia1, ambulancia2)
			);
		};
	}
}

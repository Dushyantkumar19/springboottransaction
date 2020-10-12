package com.example.transactiondemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class AppRunner implements CommandLineRunner {

	private final static Logger LOG = LoggerFactory.getLogger(AppRunner.class);

	private final BookingService bookingService;

	public AppRunner(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			bookingService.book("Alice", "Bob", "Carol", null);
		} catch (RuntimeException e) {
			LOG.error(e.getMessage());
		}

		List<String> findAllBookings = bookingService.findAllBookings();
		LOG.info("bookings: {}, ", findAllBookings);

	}
}

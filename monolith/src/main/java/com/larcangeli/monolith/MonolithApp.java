package com.larcangeli.monolith;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.repository.IProductRepository;
import com.larcangeli.monolith.persistence.repository.IRecommendationRepository;
import com.larcangeli.monolith.persistence.repository.IReviewRepository;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;

@SpringBootApplication
public class MonolithApp implements ApplicationRunner{

	private static final Logger LOG = LoggerFactory.getLogger(MonolithApp.class);

	public static void main(final String... args) {
		SpringApplication.run(MonolithApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*Iterable<Product> allProjects = productRepository.findAll();
		LOG.info("All Projects: {}", allProjects);

		Optional<Recommendation> recommendation1 = recommendationRepository.findById(1L);
		LOG.info("Recommendation by id 1: {}", recommendation1);

		long noOfReviews = reviewRepository.count();
		LOG.info("Number of reviews: {}", noOfReviews);*/

	}

}

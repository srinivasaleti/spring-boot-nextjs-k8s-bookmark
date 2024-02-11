.PHONY: up
up:
	cd bookmarker-api && ./gradlew build
	docker-compose up &

down:
	docker-compose down

test:
	cd bookmarker-api && ./gradlew test

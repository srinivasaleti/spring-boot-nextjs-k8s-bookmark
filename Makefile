.PHONY: up
up:
	cd bookmarker-api && ./gradlew build
	docker-compose up &

build:
	cd bookmarker-api && ./gradlew build

down:
	docker-compose down

test:
	cd bookmarker-api && ./gradlew test

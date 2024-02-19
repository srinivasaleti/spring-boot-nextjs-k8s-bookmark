.PHONY: build-and-push-api-image
build-and-push-api-image:
	cd bookmarker-api && ./gradlew clean build
	@docker build  -t srinivra/bookmarker-api:latest ./bookmarker-api
	docker push srinivra/bookmarker-api:latest


.PHONY: build-and-push-ui-image
build-and-push-ui-image:
	cd bookmarker-ui
	@docker build  -t srinivra/bookmarker-ui:latest ./bookmarker-ui
	docker push srinivra/bookmarker-ui:latest

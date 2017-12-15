# MVP-Core

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/me.giacoppo/mvp/badge.svg)](https://maven-badges.herokuapp.com/maven-central/me.giacoppo/mvp)

Android library written in Kotlin for providing base MVP core for Clean Architecture

## Download
Grab via Maven:
```xml
<dependency>
  <groupId>me.giacoppo</groupId>
  <artifactId>mvp</artifactId>
  <version>LATEST_VERSION</version>
  <type>pom</type>
</dependency>
```

or Gradle:
```groovy
api 'me.giacoppo:mvp:LATEST_VERSION'
```

## Usage
The library provides common libraries and classes for your application based on a Clean Architecture approach.
The library includes the abstract class `UseCase<ReturnType, ParamsWrapper>` which simplify the creation of your use cases.

Example:
```java
	public class GetMovies extends UseCase<Movie, GetMovies.Params> {

		private final MoviesRepository repository;

		public GetConfig(MoviesRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
			super(threadExecutor, postExecutionThread);
			this.repository = repository;
		}

		@Override
		protected Observable<Configuration> buildUseCaseObservable(Params params) {
			return repository.findMovies(params.category);
		}

		public static final class Params {
			private final String category;

			private Params(String category) {
				this.category = category;
			}

			public static Params forCategory(String category) {
				return new Params(category);
			}
		}
	}
```

The library also includes base interfaces for Repository Pattern approach, base ThreadExecutor & PostExecutionThread instances, default observer class

## Credits
Android Clean Architecture: 
https://github.com/android10/Android-CleanArchitecture

## License
    Copyright 2017 Giuseppe Giacoppo
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

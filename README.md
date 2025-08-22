🌦️ Weather Service (Spring Boot + OpenWeatherMap)

A simple Spring Boot REST API that fetches live weather data for any city using the OpenWeatherMap API
.
Supports defaulting to India (IN) when country is not specified.

📌 Features

Built with Spring Boot 3 and RestClient (modern replacement for RestTemplate).

Fetches current weather (temperature, feels-like, humidity, wind, description).

Default to India if no country code is provided.

Graceful error handling:

Invalid API key

City not found

Weather service unavailable

⚙️ Prerequisites

Java 17+

Maven 3.9+

A free OpenWeatherMap API key

🚀 Setup & Run

Clone the repo

git clone https://github.com/your-username/weather-service.git
cd weather-service


Configure API key
In WeatherService.java, replace:

private static final String API_KEY = "YOUR_API_KEY";


with your actual key.

Run the app

mvn spring-boot:run


or run the WeatherApplication main class from your IDE.

You should see in logs:

Tomcat started on port(s): 8080 (http)

🔗 Endpoints
Get Weather by City
GET http://localhost:8080/weather?city={city}

Examples

✅ Pune (defaults to India):

http://localhost:8080/weather?city=Pune


✅ Paris, France:

http://localhost:8080/weather?city=Paris,FR

📦 Example Response
{
  "coord": { "lon": 73.8567, "lat": 18.5204 },
  "weather": [
    { "description": "light rain" }
  ],
  "main": {
    "temp": 28.5,
    "feels_like": 30.2,
    "humidity": 74
  },
  "wind": { "speed": 3.5 },
  "name": "Pune"
}

⚠️ Error Handling

Invalid API Key:

{ "error": "Invalid or inactive API key. Please try again later." }


City Not Found:

{ "error": "City not found. Please check the city name." }


Service Down:

{ "error": "Weather service is currently unavailable. Please try later." }

🛠️ Tech Stack

Java 24

Spring Boot 3

Spring Web (RestClient)

Maven

✨ Future Improvements

Add caching to reduce API calls

Add forecast API (5-day weather)

Integrate with chatbot for natural language queries

📌 Author: Swapnil Patil

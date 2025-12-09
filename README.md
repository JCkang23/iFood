# Group 5 - Environmental Impact of Food Choice - iFood

Submitted by:

  **Akua Dede Amofa**

  **Josue Buhendwa Cikanga**

  **Kukua Kyermenua Eshun**

  **Tapiwanashe Mandiveyi**

**iFood** is a Java Swing application that evaluates the environmental impact of users' dietary choices by modeling food items and calculating the cumulative impact of a meal
through Object-Oriented Programming model. It provides an user friendly interface to build complete meals, calculate their carbon footprint and water usage.

Time spent: **63** hours spent in total

## Installation and Running the App

**_1. Compile the project from the command line_**

In the command line, navigate to the root directory of the project cd iFood, and run: mvn compile

Running from IntelliJ IDEA, enter this command: mvn clean package for the package application and then: java -jar target/iFood-1.0-SNAPSHOT.jar

**_2. Run the program_**

Run the main method that is in the EnvironmentalImpactCalculator.java with this command: mvn exec:java -Dexec.mainClass="fully.qualified.data.iFood.Main"

cd iFood
run mvn clean package for the mvn package
then run mvn exec:java to run the program through the command line

## Required Features

The following **required** functionality is completed:

- [X] Package of food items with environmental impact
  - [X] Note: These are predifined foods for the users to add on 
- [X] Users can add multiple food items to compose meals
- [X] Calculation of environmental impact as users modify their meal
- [X] User-friendly Swing interface for the users to interact with the program


The following **additional** features are implemented:

- [ ] Modern UI
- [ ] Foods organized by category that will simplify navigation
- [ ] Flexible weight input for each food item (grams)
- [ ] Environmental tips panel for sustainable eating

## Video Walkthrough

    <a href="https://www.loom.com/share/631655c2b3f248659d09cba8817e034f">
            Simulator - iPhone 15 Pro - 9 April 2024 - Watch Video
    </a>

## Notes

### Challenges encountered

- Difficulties in implementing an automated suggestions/tips array for feedback about the best meal selection - Time constraint
- Difficulties in requestion an external API to access various food data

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

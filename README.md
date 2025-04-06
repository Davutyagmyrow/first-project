# Bouncing Balls App 🎾

Java Swing animation of bouncing balls with speed control

📌 **Description**

BouncingBallsApp is a graphical Java application built with Swing that simulates bouncing balls inside a window. Each ball moves with a different initial speed and bounces off the edges of the screen. The app also includes speed control buttons to slow down or speed up the animation.

🛠️ **Technologies**
Java SE

Java Swing (GUI)

javax.swing.Timer for animation

🧩 Features
Displays multiple (7) animated balls

Balls bounce off window borders

"+" and "−" buttons to adjust animation speed

Simple, beginner-friendly structure and code

🧪 **How to Run**

Make sure you have the Java Development Kit (JDK) installed

Compile and run the program:

bash


🧠 How It Works
All balls are stored in a List<Ball>.

A javax.swing.Timer updates the position of each ball every delay milliseconds.

Speed buttons modify the delay, affecting how fast the animation updates.

📁 Code Structure
BouncingBallsApp — the main class handling GUI and rendering

Ball — an inner class representing a ball, including its position and velocity

✏️ TODO / Potential Improvements
Add ball-to-ball collision detection

Change ball colors dynamically

Support adding/removing balls

Display FPS or current speed

📄 License
This project is for educational and demonstration purposes. Feel free to use and modify it for personal or learning use.


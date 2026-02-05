🎉 Birthday Wishes App

📌 A simple, customizable Android application to send/display heartfelt birthday wishes.
This project lets you personalize the birthday greeting with text, images, audio, or video to make birthdays special!

🧠 What This App Does

🎂 Displays a birthday greeting screen.

🖼️ Shows images or animations from a pictures folder.

🎵 Plays audio or displays video from a raw folder.

🛠️ Completely customizable images, videos, and texts.

🗂 Project Structure
Birthday-Wishes/
├── app/  
│   ├── src/main/assets/
│   │   ├── pictures/         ← Place custom images here
│   ├── src/main/java/... 
│   ├── src/main/res/
│   │   ├── drawable/
│   │   ├── raw/              ← Audio & Video files
│   │   │   ├── user.json     ← Personalization config
│   │   ├── layout/           
│   │   └── values/
├── build.gradle
├── settings.gradle
└── README.md

🧩 Configuring user.json

Before running the app, you must update the user.json file.
This is where you define the birthday message, name, and other details.

Example user.json:

{
  "name": "John",
  "dob": "01/01/1999"
}

🔧 What to Customize
Key	Description
name	The name of the person to wish
dob   The date of birth of the person to wish
imageFile	Image file in pictures/         ← Add any number of images of the person you want to wish
audioFile	Audio file in raw/ (optional)   ← Can modify the birthday song with the one you like but keep in mind to keep the same file name.
videoFile	Video file in raw/ (optional)   ← Can modify the birthday video with the one you like but keep in mind to keep the same file name.

🖼️ Adding Images

Add your desired images to the pictures/ folder.
Recommended: Keep image sizes moderate (≈ 1080×1920 px or smaller) for performance.

🎶 Adding Audio / 📹 Video

Place audio (.mp3) or video (.mp4) files inside the raw/ folder under:

app/src/main/res/raw/


This way Android Studio can package them properly into the app.

📌 Audio and video are optional — if you don’t want them, just don't update anything under raw folder.

🚀 How to Run in Android Studio

Follow these simple steps to get the app up and running:

Clone the repo

git clone https://github.com/mestaabhishek/Birthday-Wishes.git


Open Android Studio

Choose Open an existing project.

Navigate to the cloned folder and open it.

Sync Gradle

Android Studio may prompt a “Gradle Sync” — allow it to finish.

Check user.json

Make sure user.json is correctly filled out.

Add media files

Put images in pictures/.

Put audio/video in app/src/main/res/raw/.

Run on device/emulator

Select a connected device or emulator.

Click Run ▶️.

🌟 Tips & Enhancements

🎁 Add custom fonts in res/font/ and use them!

🎉 Include animated GIFs or Lottie animations (needs a library).

🔊 Add sound effects if you want a musical greeting.

💬 Want to Contribute?

🛠️ Fix bugs

✨ Add new themes

📱 Support multiple screens or languages

Contributions are welcome! 🙌

# 🎉 Birthday Wishes App

📌 A simple, customizable **Android application** to send/display heartfelt birthday wishes.
This project lets you personalize the birthday greeting with text, images, audio, or video to make birthdays special!

---

## 🧠 What This App Does

* 🎂 Displays a birthday greeting screen.
* 🖼️ Shows images or animations from a `pictures` folder.
* 🎵 Plays audio or displays video from a `raw` folder.
* 🛠️ Completely customizable images, videos, and texts.

---

## 🗂 Project Structure

```bash
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
```

---

## 🧩 Configuring `user.json`

Before running the app, you must update the **`user.json`** file.
This is where you define the birthday message, name, and other details.

### Example `user.json`

```json
{
  "name": "John",
  "dob": "01/01/1999"
}
```

---

## 🔧 What to Customize

| Key         | Description                                             |
| ----------- | ------------------------------------------------------- |
| `name`      | The name of the person to wish                          |
| `dob`       | The date of birth of the person                         |
| `imageFile` | Image file in `pictures/` (you can add multiple images) |
| `audioFile` | Audio file in `raw/` *(optional – keep same filename)*  |
| `videoFile` | Video file in `raw/` *(optional – keep same filename)*  |

> ⚠️ For audio and video, you can replace the files, but **do not change the filenames** used in the code.

---

## 🖼️ Adding Images

Add your desired images to the **`pictures/`** folder.

**Recommended:**
Keep image sizes moderate (around **1080×1920 px or smaller**) for better performance.

---

## 🎶 Adding Audio / 📹 Video

Place audio (`.mp3`) or video (`.mp4`) files inside:

```
app/src/main/res/raw/
```

This allows Android Studio to bundle them correctly.

> 📌 Audio and video are optional — if you don’t want them, simply don’t update anything in the `raw` folder.

---

## 🚀 How to Run in Android Studio

Follow these simple steps:

### 1. Clone the repository

```bash
git clone https://github.com/mestaabhishek/Birthday-Wishes.git
```

### 2. Open in Android Studio

* Choose **Open an existing project**
* Select the cloned folder

### 3. Sync Gradle

* Let Android Studio complete the Gradle sync

### 4. Update `user.json`

* Add the correct name and DOB

### 5. Add media files

* Images → `pictures/`
* Audio/Video → `app/src/main/res/raw/`

### 6. Run the app

* Select a device/emulator
* Click **Run ▶️**

---

## 🌟 Tips & Enhancements

* 🎁 Add custom fonts in `res/font/`
* 🎉 Use animated GIFs or Lottie animations
* 🔊 Add sound effects for extra fun
* 🌙 Add dark mode support

---

## 💬 Want to Contribute?

You’re welcome to:

* 🛠️ Fix bugs
* ✨ Add new themes
* 📱 Support more layouts or languages

Contributions are always appreciated! 🙌

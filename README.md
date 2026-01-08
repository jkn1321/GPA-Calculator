# GPA Calculator

A modern, user-friendly Java Swing application for calculating Grade Point Average (GPA) with both console and graphical user interfaces.

## 📋 Features

### GUI Version (GPACalculatorGUI.java)
- **Modern Interface Design** - Clean and intuitive UI with color-coded sections
- **Real-time GPA Calculation** - Automatic GPA updates as you add subjects
- **Visual Status Indicators** - Emojis for Pass 😊, Repeat 😢, and MC 🤒 statuses
- **Color-Coded Rows** - Yellow highlighting for subjects requiring repeat or medical circumstances
- **Dropdown Selections** - Easy grade and credit selection with combo boxes
- **Smart Credit Handling** - Credit dropdown automatically adjusts for Non Credit courses
- **Duplicate Prevention** - Cannot add subjects with duplicate names
- **Delete Functionality** - Remove incorrect entries from the table
- **Detailed Summary Table** - View all subjects with Grade, GPV, Credit, Total, and Status
- **Running Totals** - Track total points and total credits in real-time

### Console Version (GPACalculator.java)
- **Input Validation** - Comprehensive validation for all user inputs
- **Duplicate Prevention** - Prevents entering subjects with the same name
- **Error Handling** - Clear error messages displayed inline
- **Status Tracking** - Displays Pass/Repeat/MC/Non Credit status for each subject
- **Automatic Credit Handling** - Non Credit courses automatically assigned 0 credits
- **Subject-wise Breakdown** - View grade point value and status for each entry

## 🎓 Grading System

| Grade | Grade Point Value (GPV) | Status |
|-------|------------------------|------------|
| A+    | 4.00                   | Pass       |
| A     | 4.00                   | Pass       |
| A-    | 3.70                   | Pass       |
| B+    | 3.30                   | Pass       |
| B     | 3.00                   | Pass       |
| B-    | 2.70                   | Pass       |
| C+    | 2.30                   | Pass       |
| C     | 2.00                   | Pass       |
| C-    | 1.70                   | Repeat     |
| D+    | 1.30                   | Repeat     |
| D     | 1.00                   | Repeat     |
| E     | 0.00                   | Repeat     |
| F     | 0.00                   | Repeat     |
| MC    | 0.00                   | MC         |
| NC    | 0.00                   | Non Credit |

**GPA Formula:** GPA = Total Points / Total Credits  
**Total Points:** Sum of (Grade Point Value × Credits) for all subjects

**Note:** Non Credit (NC) courses are automatically assigned 0 credits and do not affect GPA calculation.

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

### Running the GUI Version

1. **Compile the program:**
   ```bash
   javac GPACalculatorGUI.java
   ```

2. **Run the application:**
   ```bash
   java GPACalculatorGUI
   ```

### Running the Console Version

1. **Compile the program:**
   ```bash
   javac GPACalculator.java
   ```

2. **Run the application:**
   ```bash
   java GPACalculator
   ```

## 💻 Usage

### GUI Application

1. **Enter Subject Details:**
   - Type a unique subject name in the text field (duplicates not allowed)
   - Select the grade from the dropdown (A+ to F, MC, or Non Credit)
   - Select the credit value (1-4, or 0 for Non Credit)
   - Note: Credit dropdown automatically sets to 0 and disables for Non Credit courses

2. **Add Subject:**
   - Click the "Add Subject" button
   - The subject appears in the table below
   - GPA and totals update automatically
   - Yellow highlighting appears for Repeat and MC courses

3. **Delete Subject:**
   - Click on a row in the table to select it
   - Click the "Delete Selected" button
   - Totals and GPA recalculate automatically

4. **View Results:**
   - See individual subjects in the table with detailed breakdown
   - Check the Total Points and Total Credits at the bottom
   - View your calculated GPA

### Console Application

1. Enter the number of subjects
2. For each subject, provide:
   - Subject name (must be unique, no duplicates allowed)
   - Grade (A+, A, A-, B+, B, B-, C+, C, C-, D+, D, E, F, MC, NC)
   - Credit value (must be greater than 0, except for NC which is automatically 0)
3. View the status for each subject with running totals
4. See your final GPA at the end

## 🎨 Features Highlights

- **Input Validation:** All fields are validated to prevent errors and duplicates
- **Visual Feedback:** Color-coded status indicators and row highlighting (GUI)
- **User-Friendly:** Dropdown menus eliminate typing errors (GUI)
- **Professional Design:** Modern color scheme and layout (GUI)
- **Emoji Support:** Fun visual indicators using emojis - 😊 Pass, 😢 Repeat, 🤒 MC (GUI)
- **Smart Automation:** Credit automatically set to 0 for Non Credit courses
- **Error Messages:** Clear, helpful error messages for invalid inputs
- **No Duplicates:** Prevents adding subjects with the same name
- **Flexible:** Supports standard grades, medical circumstances, and non-credit courses

## 📁 Project Structure

```
GPA-Calculator/
│
├── GPACalculator.java         # Console-based version
├── GPACalculatorGUI.java      # GUI-based version
└── README.md                  
```

## 🛠️ Technologies Used

- **Java** - Core programming language
- **Java Swing** - GUI framework (for GPACalculatorGUI)
- **Java AWT** - Graphics and event handling

## 📝 Color Scheme (GUI Version)

- **Primary Blue:** #3498DB - Headers and GPA display
- **Success Green:** #2ECC71 - Add button
- **Danger Red:** #E74C3C - Delete button
- **Background Gray:** #ECF0F1 - Application background
- **Panel White:** #FFFFFF - Input panels and table
- **Dark Text:** #2C3E50 - Text color
- **Yellow Highlight:** #FFF3B0 - Repeat/MC/NC status rows

**Status Indicators:**
- 😊 Pass - For successful grades (C to A+)
- 😢 Repeat - For failing grades (C- to F)
- 🤒 MC - For medical circumstances
- Non Credit - For non-credit courses


## 📄 Special Notes

This project is for educational purposes only.

## 👤 Author

**Januli Nanayakkara**

---


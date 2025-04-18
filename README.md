# JavaFX Registration Form Application

This is a JavaFX-based registration form that collects user input, validates it using regular expressions, and navigates to a new user page upon successful submission.

##  Features

- **Input Validation with Regex**:
  -  First and Last Name: Must be between 2 and 25 characters.
  -  Date of Birth: Must be in `MM/DD/YYYY` format.
  -  Email: Must be a valid Farmingdale email address (`@farmingdale.edu`).
  -  Zip Code: Must be a valid 5-digit number.

- **Field Validation**:
  - Fields are validated **on focus lost**, with visual feedback (green = valid, red = invalid).
  - The **"Add"** button remains disabled until all fields are valid.

- **User Feedback**:
  - Displays a **success alert** when all fields are valid and the form is submitted.
  - Displays a **warning alert** when invalid or incomplete fields are submitted.

- **Scene Navigation**:
  - After successful submission, the app transitions to a **User Page** scene.
  - User input is passed to the new scene and displayed in pre-filled text fields.

- **JavaDoc Commenting**:
  - Code includes at least one JavaDoc comment with proper `@param`, `@return`, and `@throws` tags.




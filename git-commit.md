# 📝 Git Commit Message Guidelines

This guide helps you write clean, consistent, and professional Git commit messages — ideal for team collaboration, open source contributions, or building your personal portfolio.

## ✅ Structure of a Good Commit Message

```
<type>(optional scope): <short summary>

<optional body>

<optional footer>
```

### ✅ Example

```
feat(login): add login validation for empty fields

Show an alert when username or password is empty before submission.
This prevents unnecessary API calls and improves UX.

Issue: #42
```

## 🔠 Commit Types (Based on Conventional Commits)

| Type       | Description                                           |
| ---------- | ----------------------------------------------------- |
| `feat`     | A new feature                                         |
| `fix`      | A bug fix                                             |
| `docs`     | Documentation-only changes                            |
| `style`    | Code formatting only (white-space, commas, etc.)      |
| `refactor` | Code changes that neither fix a bug nor add a feature |
| `test`     | Adding or updating tests                              |
| `chore`    | Routine tasks (e.g., dependency updates, build tasks) |

## ✏️ Writing the Summary Line

- Limit to **50 characters**
- Use **imperative mood** (e.g., “add” not “added”)
- Capitalize the first letter
- Do **not** end with a period
- Be **clear and descriptive**

### ✅ Good Examples

```
fix(auth): handle invalid login response
feat(dashboard): add recent activity section
```

### ❌ Bad Examples

```
update login
final fix
bug
```

## 📝 Optional Body Section

Use the body to explain **what** and **why** — the “how” should be evident from the code.

### ✅ Example

```
feat(cart): implement cart quantity update

This change allows users to update item quantities directly in the cart.
It improves UX and prevents users from entering negative values.
```

## 🏁 Optional Footer Section

Use the footer for:

- Breaking changes
- Issue references
- Migration notes

### ✅ Example

```
BREAKING CHANGE: removed legacy authentication middleware

Issue: #123
```

## 💡 Best Practices

| Rule                       | Description                                                             |
| -------------------------- | ----------------------------------------------------------------------- |
| Use English                | Preferred in most professional environments                             |
| One purpose per commit     | Keep each commit focused and atomic                                     |
| Use imperative mood        | Write like giving a command (e.g., “fix bug”, not “fixed bug”)          |
| Be clear and concise       | Avoid vague messages like “update” or “fix”                             |
| Think about future readers | Make your message understandable for others (or yourself) in the future |
| Automate with tools        | Use tools like Commitizen and Husky to enforce commit conventions       |

## 📌 Examples of Great Commit Messages

```
feat(register): add password strength validation
fix(ui): correct button alignment on mobile view
docs(readme): update setup instructions
refactor(auth): extract token logic into separate module
```

## 🛠 Recommended Tools

| Tool                                                 | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- |
| [Commitizen](https://github.com/commitizen/cz-cli)   | Helps you write standardized commit messages         |
| [Husky](https://typicode.github.io/husky)            | Git hooks that can run scripts before commit or push |
| [Lint-Staged](https://github.com/okonet/lint-staged) | Run linters on staged files before committing        |

## 🚀 Example Commit Flow Using Commitizen

```bash
npm install -g commitizen
git add .
git cz
```

## 🧪 Writing Good Commit Messages for Testing

Use the `test` type for commits related to adding, improving, or fixing automated/manual tests.

### ✅ When to Use `test`

- Adding new unit, integration, or e2e tests
- Updating existing tests to reflect code changes
- Fixing broken test cases
- Refactoring test utilities or mocks

### ✅ Good Examples

```
test(auth): add unit tests for login failure scenarios
test(cart): update e2e tests for quantity change flow
test(api): fix flaky test on GET /products endpoint
test(utils): refactor mock data generator for reusability
```

### ❌ Bad Examples

```
add test
fix test
coba testing lagi
```

### 💡 Tips for Testing Commits

| Tip                 | Explanation                                            |
| ------------------- | ------------------------------------------------------ |
| Be specific         | Mention the module or scenario you are testing         |
| Use the `test` type | Helps CI/CD tools and teammates filter testing changes |
| Include the reason  | Especially for fixes — mention what was broken         |
| Keep tests separate | Don’t mix tests with logic — use separate commits      |

## How to contribute to papertrail-timber

Anytime you contribute to the project, please be sure to respect our [Code of Conduct](https://github.com/jdsingh/papertrail-timber/blob/master/CODE_OF_CONDUCT.md)

#### **Did you find a bug?**

* **Check if the bug might be related to a known Android issue**.

* **Ensure the bug was not already reported** by searching on GitHub under [Issues](https://github.com/jdsingh/papertrail-timber/issues).

* If you're unable to find an open issue addressing the problem, [open a new one](https://github.com/jdsingh/papertrail-timber/issues/new). Be sure to include a **title and clear description**, as much relevant information as possible, and a **code sample** or an **executable test case** demonstrating the expected behavior that is not occurring.

#### **Did you write a patch that fixes a bug?**

* Open a new GitHub pull request with the patch.

* Ensure the PR description clearly describes the problem and solution. Include the relevant issue number if applicable.

* Before submitting, please be sure you're following our Code Style and Commit guidelines stated at the end of this document.

#### **Do you intend to add a new feature or change an existing one?**

* Open a GitHub issue to discuss with the maintainers and the community before implementing it, to gather feedback and opinions about the feature and its possible implementation.

* Before submitting a PR, please be sure you're following our Code Style and Commit guidelines stated at the end of this document.

### General Code Style Rules

    * Use default Android Studio Code Style and conventions for [Kotlin](http://kotlinlang.org/docs/reference/coding-conventions.html) languages. This formatting includes both classes and resources.
    * Include a line break in the beginning and the end of the class body.
    * Keep line lengths under 100 characters. Android Studio draws a vertical line at this position by default.
    * Include correct copyright at the top of the classes.
    * Reformat Code and Optimize Imports before committing. In case you use Android Studio for commits, make sure not to select Rearrange Code.

### Commit Rules

When submitting a PR, you'll be asked to squash your commits before merging and edit the commit message to follow a particular format that can provide useful information to future readers.

#### Commit Message Format

Each commit message might consist of a header, a body and a footer. The header is the only one that is mandatory, and it includes type and subject:

```
<type>: <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

Any line of the commit message cannot be longer 100 characters! This allows the message to be easier to read on GitHub as well as in various git tools.

#### Revert

If the commit reverts a previous commit, it should begin with revert:, followed by the header of the reverted commit. In the body it should say: This reverts commit <hash>., where the hash is the SHA of the commit being reverted.

#### Type

##### Must be one of the following:

* **feat**: A new feature

* **fix**: A bug fix

* **docs**: Documentation only changes

* **style**: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)

* **refactor**: A code change that neither fixes a bug nor adds a feature

* **perf**: A code change that improves performance

* **test**: Adding missing or correcting existing tests

* **chore**: Changes to the build process or auxiliary tools and libraries such as documentation generation

#### Subject

The subject contains succinct description of the change:

use the imperative, present tense: "change" not "changed" nor "changes"
don't capitalize first letter
no dot (.) at the end

#### Body

Just as in the subject, use the imperative, present tense: "change" not "changed" nor "changes". The body should include the motivation for the change and contrast this with previous behavior.

#### Footer

The footer should contain any information about Breaking Changes and is also the place to reference GitHub issues that this commit closes.

Breaking Changes should start with the word BREAKING CHANGE: with a space or two newlines. The rest of the commit message is then used for this.

**Thanks for your contribution!**

Feature: Testing AnnaHelpline
    Verifing Scenarios for AnnaHelpline

    @whatsapp
    Scenario Outline:  AnnaHelp Line
        Given Access WebDriverManager
        Then Launch chrome "<Live>" browser


        Examples:
            | Website  | Stage                  | Live     |
            | whatsapp | Stage.url.annaHelpLine | Live.url |
Feature: Testing AnnaHelpline
    Verifing Scenarios for AnnaHelpline



    @whatsappweblaunch
    Scenario Outline:  Whatsapp Web
        Given Access WebDriverManager
        Then Launch chrome "<Live>" browser

        Examples:
            | Website  | Stage                  | Live     | Count |
            | whatsapp | Stage.url.annaHelpLine | Live.url | 5     |

    @Fetchgroupname
    Scenario Outline:  Whatsapp Web
        Given Access WebDriverManager
        Then Launch chrome "<Live>" browser
        Then get the "<Count>" groupname for whatsappweb
        


    @resultinexcelfile
    Scenario Outline:  Whatsapp Web
        Given Access WebDriverManager
        Then Launch chrome "<Live>" browser
        Then enter result "<Count1>" in excel

        Examples:
            | Website  | Stage                  | Live     | Count1 |
            | whatsapp | Stage.url.annaHelpLine | Live.url | 7      |

    @getcontactinfo
    Scenario Outline:  Whatsapp Web
        Given Access WebDriverManager
        Then Launch chrome "<Live>" browser
        Then get the groupname for whatsappweb
        Then get contact info for whatsappweb
        



        Examples:
            | Website  | Stage                  | Live     |
            | whatsapp | Stage.url.annaHelpLine | Live.url |
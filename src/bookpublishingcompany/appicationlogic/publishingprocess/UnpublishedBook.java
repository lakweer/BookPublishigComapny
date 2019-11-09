package bookpublishingcompany.appicationlogic.publishingprocess;

import java.util.HashMap;

public class UnpublishedBook extends Book {

    private HashMap<String, String> drafts;
    private BookState state = BookState.CREATED;

    private enum BookState {
        CREATED("created"),
        TYPE_SETTING_SCHEDULED("typeSettingScheduled");

        private String string;

        BookState(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }
}

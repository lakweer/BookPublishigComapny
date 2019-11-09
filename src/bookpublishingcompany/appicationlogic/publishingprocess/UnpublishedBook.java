package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class UnpublishedBook extends Book {

    private HashMap<String, String> drafts;
    private BookState state = BookState.CREATED;

    public UnpublishedBook(String name, ArrayList<Author> authors) {
        super(name, authors);
    }

    public UnpublishedBook(String id, String name, ArrayList<Author> authors) {
        super(id, name, authors);
    }

    public void setState(BookState state) {
        this.state = state;
    }

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

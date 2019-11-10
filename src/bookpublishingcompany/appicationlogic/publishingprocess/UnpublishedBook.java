package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class UnpublishedBook extends Book {

    private BookState state = BookState.CREATED;

    public UnpublishedBook(String id, String name, BookState state) {
        super(id, name);
        this.state = state;
    }
    public UnpublishedBook(String name, ArrayList<Author> authors) {
        super(name, authors);
    }

    public UnpublishedBook(String id, String name, ArrayList<Author> authors, BookState state) {
        super(id, name, authors);
        this.state = state;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public BookState getState() {
        return state;
    }

    public enum BookState {
        CREATED("created"),
        TYPE_SETTING_SCHEDULED("typeSettingScheduled"),
        TYPE_SETTING_COMPLETED("typeSettingCompleted"),
        CONTENT_EDITED("contentEdited"),
        DRAFT_PRINTING_SCHEDULED("draftPrintingScheduled"),
        DRAFT_PRINTING_COMPLETED("draftPrintingCompleted"),
        FINAL_PRINTING_SCHEDULED("finalPrintingScheduled"),
        FINAL_PRINTING_COMPLETED("finalPrintingCompleted"),
        COMPLETED("completed");

        private String string;

        BookState(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }
}

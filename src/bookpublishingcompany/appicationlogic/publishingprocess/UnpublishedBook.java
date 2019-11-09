package bookpublishingcompany.appicationlogic.publishingprocess;

import bookpublishingcompany.appicationlogic.customermanagement.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class UnpublishedBook extends Book {

    private String drafts;
    private BookState state = BookState.CREATED;
    private float price;

    public UnpublishedBook(String id, String name, String drafts, BookState state, float price) {
        super(id, name);
        this.drafts = drafts;
        this.state = state;
        this.price = price;
    }
    public UnpublishedBook(String name, ArrayList<Author> authors) {
        super(name, authors);
    }

    public UnpublishedBook(String id, String name, ArrayList<Author> authors) {
        super(id, name, authors);
    }

    public void setState(BookState state) {
        this.state = state;
    }


    public String getDrafts() {
        return drafts;
    }

    public BookState getState() {
        return state;
    }

    public float getPrice() {
        return price;
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

package interfaces.WordPress.AdminUI;

public class AdminAddPostPageUI {
    public static final String TITLE_TEXTBOX = "xpath=//h1[@aria-label='Add title']";
    public static final String CONTENT_DOCUMENT = "xpath=//p[@role='button' and @aria-label='Add default block']";
    public static final String PUBLISH_BUTTON = "xpath=//button[text()='Publish']";
    public static final String CONFIRM_PUBLISH_BUTTON = "xpath=//div[@class='editor-post-publish-panel__header']//button[text()='Publish']";
}

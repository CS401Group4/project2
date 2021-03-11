package address.gui.event;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Interface to create a custom event listener for the document
 *
 * @author Tey Jon Sornet
 * @since February 2021
 */
public interface TextChangeDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        update(e);
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        update(e);
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        update(e);
    }
}

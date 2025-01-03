/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2021  huangyuhui <huanghongxun2008@126.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.jackhuang.hmcl.ui.construct;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import org.jackhuang.hmcl.setting.Theme;
import org.jackhuang.hmcl.ui.Controllers;
import org.jackhuang.hmcl.ui.FXUtils;
import org.jackhuang.hmcl.ui.SVG;

public final class AnnouncementCard extends VBox {

    public AnnouncementCard(String title, String content, Runnable onClose) {
        TextFlow body = FXUtils.segmentToTextFlow(content, Controllers::onHyperlinkAction);
        body.setLineSpacing(4);

        BorderPane titleBar = new BorderPane();
        titleBar.getStyleClass().add("title");
        titleBar.setLeft(new Label(title));

        if (onClose != null) {
            Node hideNode = SVG.CLOSE.createIcon(Theme.blackFill(), 20, 20);
            hideNode.setOnMouseClicked(e -> onClose.run());
            hideNode.setCursor(Cursor.HAND);
            titleBar.setRight(hideNode);
        }

        getChildren().setAll(titleBar, body);
        setSpacing(16);
        getStyleClass().addAll("card", "announcement");
    }
}

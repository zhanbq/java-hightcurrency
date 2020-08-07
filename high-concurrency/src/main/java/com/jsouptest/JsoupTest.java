package com.jsouptest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.springframework.util.StringUtils;

import java.util.List;

public class JsoupTest {

    private static String processHtml(String html) {
        StringBuilder stringBuilder = new StringBuilder();
//        Document doc = Jsoup.parse(html);
        Document doc = Jsoup.parse(html);
        Element bodyElement = doc.body();
        processHtmlChildNodes(bodyElement.childNodes());
        System.out.println(bodyElement.outerHtml());
        return "";
    }

    private static void processHtmlChildNodes(List<Node> nodes) {
        nodes.forEach(node -> {
            if (node instanceof TextNode) {
                String nodeStr = ((TextNode) node).text();
                TextNode textNode =(TextNode) node;
                if (!StringUtils.isEmpty(nodeStr)) {
                    ((TextNode) node).wrap(new StringBuffer(String.format("<span class=\"sensitive\">%s</span>", nodeStr)).toString());
                }
            } else {
                processHtmlChildNodes(node.childNodes());
            }
        });
    }

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("<p style=\"text-align: center;white-space: normal;margin: 0px;padding: 0px;box-sizing: border-box;\">当我们发出人生终极三大问题<P></p></p> \n");
        processHtml(a.toString());



    }
}

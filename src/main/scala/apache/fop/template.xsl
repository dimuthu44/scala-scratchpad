<?xml version="1.0" encoding="UTF-8"?>
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm">
                <fo:region-body margin="1in"/>
            </fo:simple-page-master>
        </fo:layout-master-set>
        <fo:page-sequence master-reference="A4">
            <fo:flow flow-name="xsl-region-body">
                <fo:block font-size="12pt" text-align="center">
                    Hello, World!
                </fo:block>
            </fo:flow>
        </fo:page-sequence>
    </fo:root>

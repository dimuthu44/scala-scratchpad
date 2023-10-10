<?xml version="1.0" encoding="utf-8"?>

<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format"
         xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <!-- defines the layout master -->
    <fo:layout-master-set>
        <fo:simple-page-master master-name="first"
                               page-height="29.7cm"
                               page-width="21cm"
                               margin-top="1cm"
                               margin-bottom="2cm"
                               margin-left="2.5cm"
                               margin-right="2.5cm">
            <fo:region-body margin-top="3cm"/>
            <fo:region-before extent="3cm"/>
            <fo:region-after extent="1.5cm"/>
        </fo:simple-page-master>
    </fo:layout-master-set>

    <!-- starts actual layout -->
    <fo:page-sequence master-reference="first">

        <fo:flow flow-name="xsl-region-body">

            <!-- **************************** NEW PAGE ************************************* -->

            <!-- this defines a title level 2-->
            <fo:block font-size="16pt"
                      font-family="sans-serif"
                      space-after.optimum="15pt"
                      text-align="center"
                      break-before="page">
                Hello <fo:inline color="blue">${customerName}</fo:inline>

            </fo:block>

            <!-- normal text -->
            <fo:block text-align="start"><xsl:value-of select="$customerName"/>
            </fo:block>

        </fo:flow>
    </fo:page-sequence>
</fo:root>
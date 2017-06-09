<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
          xmlns:o="urn:schemas-microsoft-com:office:office"
          xmlns:x="urn:schemas-microsoft-com:office:excel"
          xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
          xmlns:html="http://www.w3.org/TR/REC-html40">
    <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
        <Created>2006-09-16T00:00:00Z</Created>
        <LastSaved>2017-06-06T09:23:01Z</LastSaved>
        <Version>14.00</Version>
    </DocumentProperties>
    <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
        <AllowPNG/>
        <RemovePersonalInformation/>
    </OfficeDocumentSettings>
    <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
        <WindowHeight>8010</WindowHeight>
        <WindowWidth>14805</WindowWidth>
        <WindowTopX>240</WindowTopX>
        <WindowTopY>105</WindowTopY>
        <ProtectStructure>False</ProtectStructure>
        <ProtectWindows>False</ProtectWindows>
    </ExcelWorkbook>
    <Styles>
        <Style ss:ID="Default" ss:Name="Normal">
            <Alignment ss:Vertical="Bottom"/>
            <Borders/>
            <Font ss:FontName="宋体" ss:Size="11" ss:Color="#000000"/>
            <Interior/>
            <NumberFormat/>
            <Protection/>
        </Style>
        <Style ss:ID="m198079804">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
            <Borders>
             <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
        <Style ss:ID="m198079824">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
            <Borders>
             <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
        <Style ss:ID="m198079844">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
            <Borders>
             <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
        <Style ss:ID="s16">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
        </Style>
        <Style ss:ID="s17">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
            <Borders>
             <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
        <Style ss:ID="s18">
            <Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
            <Borders>
             <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
        <Style ss:ID="s23">
            <Borders>
            <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
            <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
            </Borders>
        </Style>
    </Styles>
<#list pems as pem>
    <Worksheet ss:Name="${pem.name}">
        <Table ss:ExpandedColumnCount="400" ss:ExpandedRowCount="${1 + 4 * pem.datas?size}" x:FullColumns="1"
               x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5">
            <Column ss:AutoFitWidth="0" ss:Width="70.5"/>
            <Column ss:AutoFitWidth="0" ss:Width="82.5"/>
            <Column ss:AutoFitWidth="0" ss:Width="103.5" ss:Span="1"/>
            <Column ss:Index="5" ss:AutoFitWidth="0" ss:Width="93"/>
            <Column ss:AutoFitWidth="0" ss:Width="78"/>
            <Row ss:AutoFitHeight="0" ss:Height="26.25">
                <Cell ss:StyleID="s18"><Data ss:Type="String">用户ID</Data></Cell>
                <Cell ss:StyleID="s18"><Data ss:Type="String">用户昵称</Data></Cell>
                <Cell ss:StyleID="s18"><Data ss:Type="String">手机</Data></Cell>
                <Cell ss:StyleID="s18"><Data ss:Type="String">本期中奖</Data></Cell>
                <Cell ss:StyleID="s18"><Data ss:Type="String">统计成交量</Data></Cell>
                <Cell ss:StyleID="s16"/>
            </Row>
    <#list pem.datas as data>
            <Row>
                <Cell ss:MergeDown="3" ss:StyleID="s17"><Data ss:Type="Number">${data.userId}</Data></Cell>
                <Cell ss:MergeDown="3" ss:StyleID="s17"><Data ss:Type="String">${data.userNick}</Data></Cell>
                <Cell ss:MergeDown="3" ss:StyleID="s17"><Data ss:Type="Number">${data.loginPhone}</Data></Cell>
                <Cell ss:MergeDown="3" ss:StyleID="m198079804"><Data ss:Type="String">${data.ward}</Data></Cell>
                <#assign countFa = 0>
                <#list data.faGoods as goods>
                <#assign countFa = countFa + goods.sales>
                </#list>
                <Cell ss:MergeDown="1" ss:StyleID="m198079824"><Data ss:Type="Number">${countFa}</Data></Cell>
                <Cell ss:StyleID="s17"><Data ss:Type="String">发现好货</Data></Cell>
                <#list data.faGoods as goods>
                    <Cell ss:StyleID="s23"><Data ss:Type="Number">${goods.goodsId}</Data></Cell>
                </#list>
            </Row>
            <Row>
                <Cell ss:Index="6" ss:StyleID="s17"><Data ss:Type="String">成交量</Data></Cell>
                <#list data.faGoods as goods>
                    <Cell ss:StyleID="s23"><Data ss:Type="Number">${goods.sales}</Data></Cell>
                </#list>
            </Row>
            <Row>
                <#assign countDa = 0>
                <#list data.daily as goods>
                <#assign countDa = countDa + goods.sales>
                </#list>
                <Cell ss:Index="5" ss:MergeDown="1" ss:StyleID="m198079844"><Data ss:Type="Number">${countDa}</Data></Cell>
                <Cell ss:StyleID="s17"><Data ss:Type="String">每日发现</Data></Cell>
                <#list data.daily as goods>
                    <Cell ss:StyleID="s23"><Data ss:Type="Number">${goods.goodsId}</Data></Cell>
                </#list>
            </Row>
            <Row>
                <Cell ss:Index="6" ss:StyleID="s17"><Data ss:Type="String">成交量</Data></Cell>
                <#list data.daily as goods>
                    <Cell ss:StyleID="s23"><Data ss:Type="Number">${goods.sales}</Data></Cell>
                </#list>
            </Row>
    </#list>
        </Table>
        <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
            <PageSetup>
                <Header x:Margin="0.3"/>
                <Footer x:Margin="0.3"/>
                <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
            </PageSetup>
            <Print>
                <ValidPrinterInfo/>
                <PaperSizeIndex>9</PaperSizeIndex>
                <HorizontalResolution>600</HorizontalResolution>
                <VerticalResolution>600</VerticalResolution>
            </Print>
            <Selected/>
            <Panes>
                <Pane>
                    <Number>3</Number>
                    <ActiveRow>15</ActiveRow>
                    <ActiveCol>3</ActiveCol>
                </Pane>
            </Panes>
            <ProtectObjects>False</ProtectObjects>
            <ProtectScenarios>False</ProtectScenarios>
        </WorksheetOptions>
    </Worksheet>
</#list>
</Workbook>

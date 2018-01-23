<#if webSite??><#else><#assign webSite='hz'></#if>
<#assign mainHost='http://www.571xz.com'>
<script modulepath="common/base#config">
var webSite = '${webSite!}'
var mainHost = '${mainHost!}'
var $build = true
</script>
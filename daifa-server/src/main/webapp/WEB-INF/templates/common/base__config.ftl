<#if webSite??><#else><#assign webSite='hz'></#if>
<script modulepath="common/base#config">
var webSite = '${webSite!}'
var $build = true
</script>
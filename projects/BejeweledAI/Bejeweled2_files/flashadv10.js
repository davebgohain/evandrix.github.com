var plugin = 0;
if (navigator.mimeTypes && navigator.mimeTypes["application/x-shockwave-flash"] && navigator.mimeTypes["application/x-shockwave-flash"].enabledPlugin) {
    if (navigator.plugins && navigator.plugins["Shockwave Flash"])
        plugin = 1;
}
else if (navigator.userAgent && navigator.userAgent.indexOf("MSIE")>=0
        && (navigator.userAgent.indexOf("Windows 95")>=0 || navigator.userAgent.indexOf("Windows 98")>=0 || navigator.userAgent.indexOf("Windows NT")>=0)) {
    document.write('<SCRIPT LANGUAGE=VBScript\> \n');
    document.write('on error resume next \n');
    document.write('plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.10")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.9")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.8")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.7")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.6")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.5")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.4")))\n');
    document.write('if ( plugin <= 0 ) then plugin = ( IsObject(CreateObject("ShockwaveFlash.ShockwaveFlash.3")))\n');
    document.write('</SCRIPT\> \n');
}
if ( plugin ) {
    document.write('<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"');
    document.write(' codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=3,0,0,0" ');
    document.write(' ID=ad_banner_example WIDTH='+width+' HEIGHT='+height+' style="line-height: 1px;">');
    document.write(' <PARAM NAME=movie VALUE="'+flashurl+'?clickTAG='+clickurl+'"> <PARAM NAME=wmode VALUE=opaque> <PARAM NAME=menu VALUE=false> <PARAM NAME=quality VALUE=high> ');
    document.write(' <EMBED src="'+flashurl+'?clickTAG='+clickurl+'" wmode=opaque menu=false quality=high ');
    document.write(' swLiveConnect=FALSE WIDTH='+width+' HEIGHT='+height+'');
    document.write(' TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash">');
    document.write(' </EMBED>');
    document.write(' </OBJECT>');
} else if (!(navigator.appName && navigator.appName.indexOf("Netscape")>=0 && navigator.appVersion.indexOf("2.")>=0)){
    document.write('<A HREF="'+simpleclickurl+'">');
    document.write('<IMG SRC="'+imageurl+'" WIDTH='+width+' HEIGHT='+height+' BORDER=0>');
    document.write('</A>');
}

package simer.html.converter

/**
  * Defines mapping for HTML attribute key names to target Scala's key and function name
  *
  * For example to convert `onclick = "alert("");"` to `onClick <-- "alert("");"`
  * this map entry should be
  * {{{
  *   map.put("onclick", EventAttribute("onClick", "<--"))
  * }}}
  */

sealed trait AttributeType {
  def key: String
  def function: String
}

object AttributeType {

  case class StringAttribute(key: String,
                             function: String = ":=") extends AttributeType

  case class IntAttribute(key: String,
                          function: String = ":=") extends AttributeType

  case class DoubleAttribute(key: String,
                             function: String = ":=") extends AttributeType

  case class BooleanAttribute(key: String,
                              function: String = ":=") extends AttributeType

  object EventAttribute {
    //Event attributes shared by ScalaJS-react and Laminar
    val reactAndLaminarEventAttributes =
      Map(
        s"onchange" -> EventAttribute("onChange"),
        s"onclick" -> EventAttribute("onClick"),
        s"onclickcapture" -> EventAttribute("onClickCapture"),
        s"onetimecode" -> EventAttribute("oneTimeCode"),
        s"onabort" -> EventAttribute("onAbort"),
        s"onabortcapture" -> EventAttribute("onAbortCapture"),
        s"onanimationend" -> EventAttribute("onAnimationEnd"),
        s"onanimationendcapture" -> EventAttribute("onAnimationEndCapture"),
        s"onanimationiteration" -> EventAttribute("onAnimationIteration"),
        s"onanimationiterationcapture" -> EventAttribute("onAnimationIterationCapture"),
        s"onanimationstart" -> EventAttribute("onAnimationStart"),
        s"onanimationstartcapture" -> EventAttribute("onAnimationStartCapture"),
        s"onauxclick" -> EventAttribute("onAuxClick"),
        s"onauxclickcapture" -> EventAttribute("onAuxClickCapture"),
        s"onbeforeinput" -> EventAttribute("onBeforeInput"),
        s"onblur" -> EventAttribute("onBlur"),
        s"onblurcapture" -> EventAttribute("onBlurCapture"),
        s"oncanplay" -> EventAttribute("onCanPlay"),
        s"oncanplaycapture" -> EventAttribute("onCanPlayCapture"),
        s"oncanplaythrough" -> EventAttribute("onCanPlayThrough"),
        s"oncompositionend" -> EventAttribute("onCompositionEnd"),
        s"oncompositionstart" -> EventAttribute("onCompositionStart"),
        s"oncompositionupdate" -> EventAttribute("onCompositionUpdate"),
        s"oncontextmenu" -> EventAttribute("onContextMenu"),
        s"oncontextmenucapture" -> EventAttribute("onContextMenuCapture"),
        s"oncopy" -> EventAttribute("onCopy"),
        s"oncopycapture" -> EventAttribute("onCopyCapture"),
        s"oncut" -> EventAttribute("onCut"),
        s"oncutcapture" -> EventAttribute("onCutCapture"),
        s"ondblclick" -> EventAttribute("onDblClick"),
        s"ondoubleclick" -> EventAttribute("onDoubleClick"),
        s"ondoubleclickcapture" -> EventAttribute("onDoubleClickCapture"),
        s"ondrag" -> EventAttribute("onDrag"),
        s"ondragcapture" -> EventAttribute("onDragCapture"),
        s"ondragend" -> EventAttribute("onDragEnd"),
        s"ondragendcapture" -> EventAttribute("onDragEndCapture"),
        s"ondragenter" -> EventAttribute("onDragEnter"),
        s"ondragentercapture" -> EventAttribute("onDragEnterCapture"),
        s"ondragexit" -> EventAttribute("onDragExit"),
        s"ondragexitcapture" -> EventAttribute("onDragExitCapture"),
        s"ondragleave" -> EventAttribute("onDragLeave"),
        s"ondragleavecapture" -> EventAttribute("onDragLeaveCapture"),
        s"ondragover" -> EventAttribute("onDragOver"),
        s"ondragovercapture" -> EventAttribute("onDragOverCapture"),
        s"ondragstart" -> EventAttribute("onDragStart"),
        s"ondragstartcapture" -> EventAttribute("onDragStartCapture"),
        s"ondrop" -> EventAttribute("onDrop"),
        s"ondropcapture" -> EventAttribute("onDropCapture"),
        s"ondurationchange" -> EventAttribute("onDurationChange"),
        s"ondurationchangecapture" -> EventAttribute("onDurationChangeCapture"),
        s"onemptied" -> EventAttribute("onEmptied"),
        s"onemptiedcapture" -> EventAttribute("onEmptiedCapture"),
        s"onencrypted" -> EventAttribute("onEncrypted"),
        s"onencryptedcapture" -> EventAttribute("onEncryptedCapture"),
        s"onended" -> EventAttribute("onEnded"),
        s"onendedcapture" -> EventAttribute("onEndedCapture"),
        s"onerror" -> EventAttribute("onError"),
        s"onerrorcapture" -> EventAttribute("onErrorCapture"),
        s"onfocus" -> EventAttribute("onFocus"),
        s"onfocuscapture" -> EventAttribute("onFocusCapture"),
        s"oninput" -> EventAttribute("onInput"),
        s"oninputcapture" -> EventAttribute("onInputCapture"),
        s"oninvalid" -> EventAttribute("onInvalid"),
        s"oninvalidcapture" -> EventAttribute("onInvalidCapture"),
        s"onkeydown" -> EventAttribute("onKeyDown"),
        s"onkeydowncapture" -> EventAttribute("onKeyDownCapture"),
        s"onkeypress" -> EventAttribute("onKeyPress"),
        s"onkeypresscapture" -> EventAttribute("onKeyPressCapture"),
        s"onkeyup" -> EventAttribute("onKeyUp"),
        s"onkeyupcapture" -> EventAttribute("onKeyUpCapture"),
        s"onload" -> EventAttribute("onLoad"),
        s"onloadcapture" -> EventAttribute("onLoadCapture"),
        s"onloadstart" -> EventAttribute("onLoadStart"),
        s"onloadstartcapture" -> EventAttribute("onLoadStartCapture"),
        s"onloadeddata" -> EventAttribute("onLoadedData"),
        s"onloadeddatacapture" -> EventAttribute("onLoadedDataCapture"),
        s"onloadedmetadata" -> EventAttribute("onLoadedMetadata"),
        s"onloadedmetadatacapture" -> EventAttribute("onLoadedMetadataCapture"),
        s"onmousedown" -> EventAttribute("onMouseDown"),
        s"onmousedowncapture" -> EventAttribute("onMouseDownCapture"),
        s"onmouseenter" -> EventAttribute("onMouseEnter"),
        s"onmouseleave" -> EventAttribute("onMouseLeave"),
        s"onmousemove" -> EventAttribute("onMouseMove"),
        s"onmousemovecapture" -> EventAttribute("onMouseMoveCapture"),
        s"onmouseout" -> EventAttribute("onMouseOut"),
        s"onmouseoutcapture" -> EventAttribute("onMouseOutCapture"),
        s"onmouseover" -> EventAttribute("onMouseOver"),
        s"onmouseovercapture" -> EventAttribute("onMouseOverCapture"),
        s"onmouseup" -> EventAttribute("onMouseUp"),
        s"onmouseupcapture" -> EventAttribute("onMouseUpCapture"),
        s"onpaste" -> EventAttribute("onPaste"),
        s"onpastecapture" -> EventAttribute("onPasteCapture"),
        s"onpause" -> EventAttribute("onPause"),
        s"onpausecapture" -> EventAttribute("onPauseCapture"),
        s"onplay" -> EventAttribute("onPlay"),
        s"onplaycapture" -> EventAttribute("onPlayCapture"),
        s"onplaying" -> EventAttribute("onPlaying"),
        s"onplayingcapture" -> EventAttribute("onPlayingCapture"),
        s"ongotpointercapture" -> EventAttribute("onGotPointerCapture"),
        s"onlostpointercapture" -> EventAttribute("onLostPointerCapture"),
        s"onpointercancel" -> EventAttribute("onPointerCancel"),
        s"onpointerdown" -> EventAttribute("onPointerDown"),
        s"onpointerenter" -> EventAttribute("onPointerEnter"),
        s"onpointerleave" -> EventAttribute("onPointerLeave"),
        s"onpointermove" -> EventAttribute("onPointerMove"),
        s"onpointerout" -> EventAttribute("onPointerOut"),
        s"onpointerover" -> EventAttribute("onPointerOver"),
        s"onpointerup" -> EventAttribute("onPointerUp"),
        s"onprogress" -> EventAttribute("onProgress"),
        s"onprogresscapture" -> EventAttribute("onProgressCapture"),
        s"onratechange" -> EventAttribute("onRateChange"),
        s"onratechangecapture" -> EventAttribute("onRateChangeCapture"),
        s"onreset" -> EventAttribute("onReset"),
        s"onresetcapture" -> EventAttribute("onResetCapture"),
        s"onscroll" -> EventAttribute("onScroll"),
        s"onscrollcapture" -> EventAttribute("onScrollCapture"),
        s"onseeked" -> EventAttribute("onSeeked"),
        s"onseekedcapture" -> EventAttribute("onSeekedCapture"),
        s"onseeking" -> EventAttribute("onSeeking"),
        s"onseekingcapture" -> EventAttribute("onSeekingCapture"),
        s"onselect" -> EventAttribute("onSelect"),
        s"onstalled" -> EventAttribute("onStalled"),
        s"onstalledcapture" -> EventAttribute("onStalledCapture"),
        s"onsubmit" -> EventAttribute("onSubmit"),
        s"onsubmitcapture" -> EventAttribute("onSubmitCapture"),
        s"onsuspend" -> EventAttribute("onSuspend"),
        s"onsuspendcapture" -> EventAttribute("onSuspendCapture"),
        s"ontimeupdate" -> EventAttribute("onTimeUpdate"),
        s"ontimeupdatecapture" -> EventAttribute("onTimeUpdateCapture"),
        s"ontouchcancel" -> EventAttribute("onTouchCancel"),
        s"ontouchcancelcapture" -> EventAttribute("onTouchCancelCapture"),
        s"ontouchend" -> EventAttribute("onTouchEnd"),
        s"ontouchendcapture" -> EventAttribute("onTouchEndCapture"),
        s"ontouchmove" -> EventAttribute("onTouchMove"),
        s"ontouchmovecapture" -> EventAttribute("onTouchMoveCapture"),
        s"ontouchstart" -> EventAttribute("onTouchStart"),
        s"ontouchstartcapture" -> EventAttribute("onTouchStartCapture"),
        s"ontransitionend" -> EventAttribute("onTransitionEnd"),
        s"ontransitionendcapture" -> EventAttribute("onTransitionEndCapture"),
        s"onvolumechange" -> EventAttribute("onVolumeChange"),
        s"onvolumechangecapture" -> EventAttribute("onVolumeChangeCapture"),
        s"onwaiting" -> EventAttribute("onWaiting"),
        s"onwaitingcapture" -> EventAttribute("onWaitingCapture"),
        s"onwheel" -> EventAttribute("onWheel"),
        s"onwheelcapture" -> EventAttribute("onWheelCapture")
      )
  }
  case class EventAttribute(key: String,
                            function: String = "-->") extends AttributeType
}

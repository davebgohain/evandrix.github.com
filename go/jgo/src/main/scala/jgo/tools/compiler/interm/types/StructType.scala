package jgo.tools.compiler
package interm
package types

import member._

case class StructType(fields: List[FieldDesc]) extends UnderType {
  val semantics = Value
  
  override val members = {
    var mbrs: Map[String, Member] = Map()
    for (field <- fields) field match {
      case RegularFieldDesc(n, t, tag) =>
        mbrs += (n -> FieldMember(this, n, t))
      case EmbeddedFieldDesc(n, tn, isP, tag) =>
        val t = if (isP) PointerType(tn) else tn
        mbrs += (n -> FieldMember(this, n, t))
    }
    mbrs
  }
}

sealed abstract class FieldDesc {
  val name:   String
  val typeOf: Type
  val tag:    Option[String]
}

case class RegularFieldDesc(
  name:   String,
  typeOf: Type,
  tag:    Option[String] = None)
extends FieldDesc

case class EmbeddedFieldDesc(
  name:   String,
  typeOf: NamedType,
  isPtr:  Boolean,
  tag:    Option[String] = None)
extends FieldDesc

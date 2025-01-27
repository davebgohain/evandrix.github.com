/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Thrift;
using Thrift.Collections;
using Thrift.Protocol;
using Thrift.Transport;
namespace Evernote.EDAM.NoteStore
{

  [Serializable]
  public partial class NotesMetadataList : TBase
  {
    private int startIndex;
    private int totalNotes;
    private List<NoteMetadata> notes;
    private List<string> stoppedWords;
    private List<string> searchedWords;
    private int updateCount;

    public int StartIndex
    {
      get
      {
        return startIndex;
      }
      set
      {
        __isset.startIndex = true;
        this.startIndex = value;
      }
    }

    public int TotalNotes
    {
      get
      {
        return totalNotes;
      }
      set
      {
        __isset.totalNotes = true;
        this.totalNotes = value;
      }
    }

    public List<NoteMetadata> Notes
    {
      get
      {
        return notes;
      }
      set
      {
        __isset.notes = true;
        this.notes = value;
      }
    }

    public List<string> StoppedWords
    {
      get
      {
        return stoppedWords;
      }
      set
      {
        __isset.stoppedWords = true;
        this.stoppedWords = value;
      }
    }

    public List<string> SearchedWords
    {
      get
      {
        return searchedWords;
      }
      set
      {
        __isset.searchedWords = true;
        this.searchedWords = value;
      }
    }

    public int UpdateCount
    {
      get
      {
        return updateCount;
      }
      set
      {
        __isset.updateCount = true;
        this.updateCount = value;
      }
    }


    public Isset __isset;
    [Serializable]
    public struct Isset {
      public bool startIndex;
      public bool totalNotes;
      public bool notes;
      public bool stoppedWords;
      public bool searchedWords;
      public bool updateCount;
    }

    public NotesMetadataList() {
    }

    public void Read (TProtocol iprot)
    {
      TField field;
      iprot.ReadStructBegin();
      while (true)
      {
        field = iprot.ReadFieldBegin();
        if (field.Type == TType.Stop) { 
          break;
        }
        switch (field.ID)
        {
          case 1:
            if (field.Type == TType.I32) {
              this.startIndex = iprot.ReadI32();
              this.__isset.startIndex = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 2:
            if (field.Type == TType.I32) {
              this.totalNotes = iprot.ReadI32();
              this.__isset.totalNotes = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 3:
            if (field.Type == TType.List) {
              {
                this.notes = new List<NoteMetadata>();
                TList _list64 = iprot.ReadListBegin();
                for( int _i65 = 0; _i65 < _list64.Count; ++_i65)
                {
                  NoteMetadata _elem66 = new NoteMetadata();
                  _elem66 = new NoteMetadata();
                  _elem66.Read(iprot);
                  this.notes.Add(_elem66);
                }
                iprot.ReadListEnd();
              }
              this.__isset.notes = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 4:
            if (field.Type == TType.List) {
              {
                this.stoppedWords = new List<string>();
                TList _list67 = iprot.ReadListBegin();
                for( int _i68 = 0; _i68 < _list67.Count; ++_i68)
                {
                  string _elem69 = null;
                  _elem69 = iprot.ReadString();
                  this.stoppedWords.Add(_elem69);
                }
                iprot.ReadListEnd();
              }
              this.__isset.stoppedWords = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 5:
            if (field.Type == TType.List) {
              {
                this.searchedWords = new List<string>();
                TList _list70 = iprot.ReadListBegin();
                for( int _i71 = 0; _i71 < _list70.Count; ++_i71)
                {
                  string _elem72 = null;
                  _elem72 = iprot.ReadString();
                  this.searchedWords.Add(_elem72);
                }
                iprot.ReadListEnd();
              }
              this.__isset.searchedWords = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          case 6:
            if (field.Type == TType.I32) {
              this.updateCount = iprot.ReadI32();
              this.__isset.updateCount = true;
            } else { 
              TProtocolUtil.Skip(iprot, field.Type);
            }
            break;
          default: 
            TProtocolUtil.Skip(iprot, field.Type);
            break;
        }
        iprot.ReadFieldEnd();
      }
      iprot.ReadStructEnd();
    }

    public void Write(TProtocol oprot) {
      TStruct struc = new TStruct("NotesMetadataList");
      oprot.WriteStructBegin(struc);
      TField field = new TField();
      if (__isset.startIndex) {
        field.Name = "startIndex";
        field.Type = TType.I32;
        field.ID = 1;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(this.startIndex);
        oprot.WriteFieldEnd();
      }
      if (__isset.totalNotes) {
        field.Name = "totalNotes";
        field.Type = TType.I32;
        field.ID = 2;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(this.totalNotes);
        oprot.WriteFieldEnd();
      }
      if (this.notes != null && __isset.notes) {
        field.Name = "notes";
        field.Type = TType.List;
        field.ID = 3;
        oprot.WriteFieldBegin(field);
        {
          oprot.WriteListBegin(new TList(TType.Struct, this.notes.Count));
          foreach (NoteMetadata _iter73 in this.notes)
          {
            _iter73.Write(oprot);
            oprot.WriteListEnd();
          }
        }
        oprot.WriteFieldEnd();
      }
      if (this.stoppedWords != null && __isset.stoppedWords) {
        field.Name = "stoppedWords";
        field.Type = TType.List;
        field.ID = 4;
        oprot.WriteFieldBegin(field);
        {
          oprot.WriteListBegin(new TList(TType.String, this.stoppedWords.Count));
          foreach (string _iter74 in this.stoppedWords)
          {
            oprot.WriteString(_iter74);
            oprot.WriteListEnd();
          }
        }
        oprot.WriteFieldEnd();
      }
      if (this.searchedWords != null && __isset.searchedWords) {
        field.Name = "searchedWords";
        field.Type = TType.List;
        field.ID = 5;
        oprot.WriteFieldBegin(field);
        {
          oprot.WriteListBegin(new TList(TType.String, this.searchedWords.Count));
          foreach (string _iter75 in this.searchedWords)
          {
            oprot.WriteString(_iter75);
            oprot.WriteListEnd();
          }
        }
        oprot.WriteFieldEnd();
      }
      if (__isset.updateCount) {
        field.Name = "updateCount";
        field.Type = TType.I32;
        field.ID = 6;
        oprot.WriteFieldBegin(field);
        oprot.WriteI32(this.updateCount);
        oprot.WriteFieldEnd();
      }
      oprot.WriteFieldStop();
      oprot.WriteStructEnd();
    }

    public override string ToString() {
      StringBuilder sb = new StringBuilder("NotesMetadataList(");
      sb.Append("startIndex: ");
      sb.Append(this.startIndex);
      sb.Append(",totalNotes: ");
      sb.Append(this.totalNotes);
      sb.Append(",notes: ");
      sb.Append(this.notes);
      sb.Append(",stoppedWords: ");
      sb.Append(this.stoppedWords);
      sb.Append(",searchedWords: ");
      sb.Append(this.searchedWords);
      sb.Append(",updateCount: ");
      sb.Append(this.updateCount);
      sb.Append(")");
      return sb.ToString();
    }

  }

}

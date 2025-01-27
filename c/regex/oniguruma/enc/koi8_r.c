/**********************************************************************

  koi8_r.c -  Oniguruma (regular expression library)

  Copyright (C) 2004  K.Kosako (sndgk393 AT ybb DOT ne DOT jp)

**********************************************************************/
#include "regenc.h"

#define ENC_KOI8_R_TO_LOWER_CASE(c) EncKOI8_R_ToLowerCaseTable[c]
#define ENC_IS_KOI8_R_CTYPE(code,ctype) \
  ((EncKOI8_R_CtypeTable[code] & ctype) != 0)

static UChar EncKOI8_R_ToLowerCaseTable[256] = {
  '\000', '\001', '\002', '\003', '\004', '\005', '\006', '\007',
  '\010', '\011', '\012', '\013', '\014', '\015', '\016', '\017',
  '\020', '\021', '\022', '\023', '\024', '\025', '\026', '\027',
  '\030', '\031', '\032', '\033', '\034', '\035', '\036', '\037',
  '\040', '\041', '\042', '\043', '\044', '\045', '\046', '\047',
  '\050', '\051', '\052', '\053', '\054', '\055', '\056', '\057',
  '\060', '\061', '\062', '\063', '\064', '\065', '\066', '\067',
  '\070', '\071', '\072', '\073', '\074', '\075', '\076', '\077',
  '\100', '\141', '\142', '\143', '\144', '\145', '\146', '\147',
  '\150', '\151', '\152', '\153', '\154', '\155', '\156', '\157',
  '\160', '\161', '\162', '\163', '\164', '\165', '\166', '\167',
  '\170', '\171', '\172', '\133', '\134', '\135', '\136', '\137',
  '\140', '\141', '\142', '\143', '\144', '\145', '\146', '\147',
  '\150', '\151', '\152', '\153', '\154', '\155', '\156', '\157',
  '\160', '\161', '\162', '\163', '\164', '\165', '\166', '\167',
  '\170', '\171', '\172', '\173', '\174', '\175', '\176', '\177',
  '\200', '\201', '\202', '\203', '\204', '\205', '\206', '\207',
  '\210', '\211', '\212', '\213', '\214', '\215', '\216', '\217',
  '\220', '\221', '\222', '\223', '\224', '\225', '\226', '\227',
  '\230', '\231', '\232', '\233', '\234', '\235', '\236', '\237',
  '\240', '\241', '\242', '\243', '\244', '\245', '\246', '\247',
  '\250', '\251', '\252', '\253', '\254', '\255', '\256', '\257',
  '\260', '\261', '\262', '\243', '\264', '\265', '\266', '\267',
  '\270', '\271', '\272', '\273', '\274', '\275', '\276', '\277',
  '\300', '\301', '\302', '\303', '\304', '\305', '\306', '\307',
  '\310', '\311', '\312', '\313', '\314', '\315', '\316', '\317',
  '\320', '\321', '\322', '\323', '\324', '\325', '\326', '\327',
  '\330', '\331', '\332', '\333', '\334', '\335', '\336', '\337',
  '\300', '\301', '\302', '\303', '\304', '\305', '\306', '\307',
  '\310', '\311', '\312', '\313', '\314', '\315', '\316', '\317',
  '\320', '\321', '\322', '\323', '\324', '\325', '\326', '\327',
  '\330', '\331', '\332', '\333', '\334', '\335', '\336', '\337'
};

static unsigned short EncKOI8_R_CtypeTable[256] = {
  0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004,
  0x1004, 0x1106, 0x1104, 0x1104, 0x1104, 0x1104, 0x1004, 0x1004,
  0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004,
  0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004, 0x1004,
  0x1142, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0,
  0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0,
  0x1c58, 0x1c58, 0x1c58, 0x1c58, 0x1c58, 0x1c58, 0x1c58, 0x1c58,
  0x1c58, 0x1c58, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x10d0,
  0x10d0, 0x1e51, 0x1e51, 0x1e51, 0x1e51, 0x1e51, 0x1e51, 0x1a51,
  0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51,
  0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51, 0x1a51,
  0x1a51, 0x1a51, 0x1a51, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x18d0,
  0x10d0, 0x1c71, 0x1c71, 0x1c71, 0x1c71, 0x1c71, 0x1c71, 0x1871,
  0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871,
  0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871, 0x1871,
  0x1871, 0x1871, 0x1871, 0x10d0, 0x10d0, 0x10d0, 0x10d0, 0x1004,
  0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0142, 0x0050, 0x0050, 0x0850, 0x00d0, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0871, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0a51, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050, 0x0050,
  0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871,
  0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871,
  0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871,
  0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871, 0x0871,
  0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51,
  0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51,
  0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51,
  0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51, 0x0a51
};

static int
koi8_r_mbc_to_lower(UChar* p, UChar* lower)
{
  *lower = ENC_KOI8_R_TO_LOWER_CASE(*p);
  return 1; /* return byte length of converted char to lower */
}

static int
koi8_r_mbc_is_case_ambig(UChar* p)
{
  int v = (EncKOI8_R_CtypeTable[*p] &
	   (ONIGENC_CTYPE_UPPER | ONIGENC_CTYPE_LOWER));

  return ((v != 0) ? TRUE : FALSE);
}

static int
koi8_r_code_is_ctype(OnigCodePoint code, unsigned int ctype)
{
  if (code < 256)
    return ENC_IS_KOI8_R_CTYPE(code, ctype);
  else
    return FALSE;
}

OnigEncodingType OnigEncodingKOI8_R = {
  {
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
  },
  "KOI8-R",       /* name */
  1,              /* max byte length */
  FALSE,          /* is_fold_match */
  ONIGENC_CTYPE_SUPPORT_LEVEL_SB,    /* ctype_support_level */
  TRUE,          /* is continuous sb mb codepoint */
  onigenc_single_byte_mbc_to_code,
  onigenc_single_byte_code_to_mbclen,
  onigenc_single_byte_code_to_mbc,
  koi8_r_mbc_to_lower,
  koi8_r_mbc_is_case_ambig,
  koi8_r_code_is_ctype,
  onigenc_nothing_get_ctype_code_range,
  onigenc_single_byte_left_adjust_char_head,
  onigenc_single_byte_is_allowed_reverse_match,
  onigenc_nothing_get_all_fold_match_code,
  onigenc_nothing_get_fold_match_info
};

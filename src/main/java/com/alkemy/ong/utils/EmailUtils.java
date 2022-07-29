package com.alkemy.ong.utils;


public class EmailUtils {

   public static String content(String tittle, String msg) {
       return "<!doctype html>\n" +
               "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
               "  xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
               "\n" +
               "<head>\n" +
               "  <title>\n" +
               "\n" +
               "  </title>\n" +
               "  \n" +
               "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
               "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
               "  <style type=\"text/css\">\n" +
               "    #outlook a {\n" +
               "      padding: 0;\n" +
               "    }\n" +
               "\n" +
               "    .ReadMsgBody {\n" +
               "      width: 100%;\n" +
               "    }\n" +
               "\n" +
               "    .ExternalClass {\n" +
               "      width: 100%;\n" +
               "    }\n" +
               "\n" +
               "    .ExternalClass * {\n" +
               "      line-height: 100%;\n" +
               "    }\n" +
               "\n" +
               "    body {\n" +
               "      margin: 0;\n" +
               "      padding: 0;\n" +
               "      -webkit-text-size-adjust: 100%;\n" +
               "      -ms-text-size-adjust: 100%;\n" +
               "    }\n" +
               "\n" +
               "    table,\n" +
               "    td {\n" +
               "      border-collapse: collapse;\n" +
               "      mso-table-lspace: 0pt;\n" +
               "      mso-table-rspace: 0pt;\n" +
               "    }\n" +
               "\n" +
               "    img {\n" +
               "      border: 0;\n" +
               "      height: auto;\n" +
               "      line-height: 100%;\n" +
               "      outline: none;\n" +
               "      text-decoration: none;\n" +
               "      -ms-interpolation-mode: bicubic;\n" +
               "    }\n" +
               "\n" +
               "    p {\n" +
               "      display: block;\n" +
               "      margin: 13px 0;\n" +
               "    }\n" +
               "  </style>\n" +
               "\n" +
               "  <!--[if !mso]><!-->\n" +
               "  <link href=\"https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
               "  <link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
               "  <style type=\"text/css\">\n" +
               "    @import url(https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700);\n" +
               "    @import url(https://fonts.googleapis.com/css?family=Cabin:400,700);\n" +
               "  </style>\n" +
               "  <!--<![endif]-->\n" +
               "\n" +
               "\n" +
               "\n" +
               "  <style type=\"text/css\">\n" +
               "    @media only screen and (min-width:480px) {\n" +
               "      .mj-column-per-100 {\n" +
               "        width: 100% !important;\n" +
               "        max-width: 100%;\n" +
               "      }\n" +
               "    }\n" +
               "  </style>\n" +
               "\n" +
               "\n" +
               "  <style type=\"text/css\">\n" +
               "    @media only screen and (max-width:480px) {\n" +
               "      table.full-width-mobile {\n" +
               "        width: 100% !important;\n" +
               "      }\n" +
               "\n" +
               "      td.full-width-mobile {\n" +
               "        width: auto !important;\n" +
               "      }\n" +
               "    }\n" +
               "  </style>\n" +
               "  <style type=\"text/css\">\n" +
               "    .hide_on_mobile {\n" +
               "      display: none !important;\n" +
               "    }\n" +
               "\n" +
               "    @media only screen and (min-width: 480px) {\n" +
               "      .hide_on_mobile {\n" +
               "        display: block !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "    .hide_section_on_mobile {\n" +
               "      display: none !important;\n" +
               "    }\n" +
               "\n" +
               "    @media only screen and (min-width: 480px) {\n" +
               "      .hide_section_on_mobile {\n" +
               "        display: table !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "    .hide_on_desktop {\n" +
               "      display: block !important;\n" +
               "    }\n" +
               "\n" +
               "    @media only screen and (min-width: 480px) {\n" +
               "      .hide_on_desktop {\n" +
               "        display: none !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "    .hide_section_on_desktop {\n" +
               "      display: table !important;\n" +
               "    }\n" +
               "\n" +
               "    @media only screen and (min-width: 480px) {\n" +
               "      .hide_section_on_desktop {\n" +
               "        display: none !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "    [owa] .mj-column-per-100 {\n" +
               "      width: 100% !important;\n" +
               "    }\n" +
               "\n" +
               "    [owa] .mj-column-per-50 {\n" +
               "      width: 50% !important;\n" +
               "    }\n" +
               "\n" +
               "    [owa] .mj-column-per-33 {\n" +
               "      width: 33.333333333333336% !important;\n" +
               "    }\n" +
               "\n" +
               "    p,\n" +
               "    h1,\n" +
               "    h2,\n" +
               "    h3 {\n" +
               "      margin: 0px;\n" +
               "    }\n" +
               "\n" +
               "    a {\n" +
               "      text-decoration: none;\n" +
               "      color: inherit;\n" +
               "    }\n" +
               "\n" +
               "    @media only print and (min-width:480px) {\n" +
               "      .mj-column-per-100 {\n" +
               "        width: 100% !important;\n" +
               "      }\n" +
               "\n" +
               "      .mj-column-per-40 {\n" +
               "        width: 40% !important;\n" +
               "      }\n" +
               "\n" +
               "      .mj-column-per-60 {\n" +
               "        width: 60% !important;\n" +
               "      }\n" +
               "\n" +
               "      .mj-column-per-50 {\n" +
               "        width: 50% !important;\n" +
               "      }\n" +
               "\n" +
               "      mj-column-per-33 {\n" +
               "        width: 33.333333333333336% !important;\n" +
               "      }\n" +
               "    }\n" +
               "  </style>\n" +
               "\n" +
               "</head>\n" +
               "\n" +
               "<body style=\"background-color:#52c0f7;\">\n" +
               "\n" +
               "\n" +
               "  <div style=\"background-color:#52c0f7;\">\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "    <div style=\"Margin:0px auto;max-width:600px;\">\n" +
               "\n" +
               "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\">\n" +
               "        <tbody>\n" +
               "          <tr>\n" +
               "            <td style=\"direction:ltr;font-size:0px;padding:9px 0px 9px 0px;text-align:center;vertical-align:top;\">\n" +
               "\n" +
               "              <div class=\"mj-column-per-100 outlook-group-fix\"\n" +
               "                style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\">\n" +
               "\n" +
               "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\"\n" +
               "                  width=\"100%\">\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:50px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                </table>\n" +
               "\n" +
               "              </div>\n" +
               "\n" +
               "            </td>\n" +
               "          </tr>\n" +
               "        </tbody>\n" +
               "      </table>\n" +
               "\n" +
               "    </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "    <div style=\"background:#FFFFFF;background-color:#FFFFFF;Margin:0px auto;max-width:600px;\">\n" +
               "\n" +
               "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"\n" +
               "        style=\"background:#FFFFFF;background-color:#FFFFFF;width:100%;\">\n" +
               "        <tbody>\n" +
               "          <tr>\n" +
               "            <td style=\"direction:ltr;font-size:0px;padding:9px 0px 9px 0px;text-align:center;vertical-align:top;\">\n" +
               "\n" +
               "\n" +
               "              <div class=\"mj-column-per-100 outlook-group-fix\"\n" +
               "                style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\">\n" +
               "\n" +
               "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\"\n" +
               "                  width=\"100%\">\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:30px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td align=\"center\" style=\"font-size:0px;padding:0px 0px 0px 0px;word-break:break-word;\">\n" +
               "\n" +
               "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"\n" +
               "                        style=\"border-collapse:collapse;border-spacing:0px;\">\n" +
               "                        <tbody>\n" +
               "                          <tr>\n" +
               "                            <td style=\"width:312px;\">\n" +
               "\n" +
               "                              <img height=\"auto\"\n" +
               "                                src=\"https://s3-eu-west-1.amazonaws.com/topolio/uploads/6082338c1a7ee/1619145692.jpg\"\n" +
               "                                style=\"border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;\"\n" +
               "                                width=\"312\">\n" +
               "\n" +
               "                            </td>\n" +
               "                          </tr>\n" +
               "                        </tbody>\n" +
               "                      </table>\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:50px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td align=\"left\" style=\"font-size:0px;padding:15px 15px 15px 15px;word-break:break-word;\">\n" +
               "\n" +
               "                      <div\n" +
               "                        style=\"font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:11px;line-height:1.5;text-align:left;color:#000000;\">\n" +
               "                        <p style=\"text-align: center;\"><span\n" +
               "                            style=\"font-size: 24px;\"><strong>"+tittle+"</strong></span></p>\n" +
               "                        <p style=\"text-align: center;\">&nbsp;</p>\n" +
               "                        <p style=\"text-align: center;\"><span style=\"font-size: 16px;\">"+msg+"</span></p>\n" +
               "                      </div>\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:30px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td align=\"left\" style=\"font-size:0px;padding:15px 15px 15px 15px;word-break:break-word;\">\n" +
               "\n" +
               "                      <div\n" +
               "                        style=\"font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:11px;line-height:1.5;text-align:left;color:#000000;\">\n" +
               "                        <p style=\"text-align: center;\">Datos de contacto de ONG</p>\n" +
               "                      </div>\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:30px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                </table>\n" +
               "\n" +
               "              </div>\n" +
               "\n" +
               "            </td>\n" +
               "          </tr>\n" +
               "        </tbody>\n" +
               "      </table>\n" +
               "\n" +
               "    </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "\n" +
               "    <div style=\"Margin:0px auto;max-width:600px;\">\n" +
               "\n" +
               "      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width:100%;\">\n" +
               "        <tbody>\n" +
               "          <tr>\n" +
               "            <td style=\"direction:ltr;font-size:0px;padding:9px 0px 9px 0px;text-align:center;vertical-align:top;\">\n" +
               "\n" +
               "\n" +
               "              <div class=\"mj-column-per-100 outlook-group-fix\"\n" +
               "                style=\"font-size:13px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;\">\n" +
               "\n" +
               "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"vertical-align:top;\"\n" +
               "                  width=\"100%\">\n" +
               "\n" +
               "                  <tr>\n" +
               "                    <td style=\"font-size:0px;word-break:break-word;\">\n" +
               "\n" +
               "\n" +
               "                      <div style=\"height:50px;\">\n" +
               "                        &nbsp;\n" +
               "                      </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "                    </td>\n" +
               "                  </tr>\n" +
               "\n" +
               "                </table>\n" +
               "\n" +
               "              </div>\n" +
               "\n" +
               "            </td>\n" +
               "          </tr>\n" +
               "        </tbody>\n" +
               "      </table>\n" +
               "\n" +
               "    </div>\n" +
               "\n" +
               "\n" +
               "\n" +
               "  </div>\n" +
               "\n" +
               "</body>\n" +
               "\n" +
               "</html>";
   }
}

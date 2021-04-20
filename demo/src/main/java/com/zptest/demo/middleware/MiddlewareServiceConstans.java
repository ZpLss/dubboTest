package com.zptest.demo.middleware;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by wangxin on 2017/5/9.
 */
public class MiddlewareServiceConstans {

    /**
     * 响应格式
     */
    public static String PARAM_FORMAT;

    /**
     * 签名客户ID
     */
    public static String PARAM_MERID;

    /**
     * 签名信息版本
     */
    public static String PARAM_VERSION;

    /**
     * 签名信息交易渠道
     */
    public static String PARAM_CHANNEL;

    /**
     * 投资者类型,p:个人,o:机构
     */
    public static String PARAM_USERTYPE;

    /**
     * 签名方式
     */
    public static String PARAM_SIGNMODE;

    /**
     * 自定义委托方式
     */
    public static String PARAM_CUSTTRUST;

    /**
     * 签名信息
     */
    public static String PARAM_SIGNMSG;

    /**
     * 统一账户APPID
     */
    public static String PARAM_AZ_APPID;

    /**
     * PARAM_ORGCHANNEL
     * 100：web,
     * 201：Android,
     * 202：iOS,
     * 300：微信
     */
    public static String PARAM_ORGCHANNEL;


    /**
     * 加密key
     */
    public static String AES_KEY;

    /**
     * 地址结尾
     */
    public static final String ADDRESS_TAIL = ".do";

    /**
     * 成功码
     */
    public static String SUCCESS;

    /**
     * 中间层用户登录状态到期code
     */
    public static final String LOGIN_EXPIRE_CODE = "10051702";

    /**
     * 中间层用户登录状态其他设备登录
     */
    public static final String LOGIN_OTHERDEVICE_CODE = "20050109";

    /**
     * 调用中间件返回升级改造中
     */
    public static final String UPGRADING_CODE = "99999991";

    /**
     * 中间件服务器根路径
     */
    public static String MIDDLEWARE_SERVER_ROOT_PATH;



    public static final String FLUSHAPIINFO_NAME = "刷新";
    public static final String FLUSHAPIINFO = "/flush/flushApiInfo";

    public static final String QUERY_STRATEGY_DRAW_DWN_NAME = "查询最大回撤";
    public static final String QUERY_STRATEGY_DRAW_DWN = "/global/queryStrategyDrawDwn";


    public static final String QUERY_MONTH_REPORT_NAME = "查询月报";
    public static final String QUERY_MONTH_REPORT = "/person/query/queryMonthReport";


    public static final String GLOBAL_ACCOUNT_SENDVERIFYCODE_NAME = "发送验证码";
    public static final String GLOBAL_ACCOUNT_SENDVERIFYCODE = "/global/sendVerifyCode";

    public static final String GLOBAL_ACCOUNT_CHECKVERIFYCODE_NAME = "验证验证码";
    public static final String GLOBAL_ACCOUNT_CHECKVERIFYCODE = "/global/checkVerifyCode";

    public static final String GLOBAL_QUERY_GETWORKDATE_NAME = "查询工作日";
    public static final String GLOBAL_QUERY_GETWORKDATE = "/global/getWorkDate";

    public static final String GLOBAL_QUERY_GETNEXTWORKDATE_NAME = "下一个工作日";
    public static final String GLOBAL_QUERY_GETNEXTWORKDATE = "/global/getNextWorkDate";

    public static final String GLOBAL_QUERY_CHECKWORKDATE_NAME = "是否为工作日";
    public static final String GLOBAL_QUERY_CHECKWORKDATE = "/global/checkWorkDate";

    public static final String GLOBAL_QUERY_APIDICTIONARY_NAME = "查询字典";
    public static final String GLOBAL_QUERY_APIDICTIONARY = "/global/apiDictionary";


    public static final String LOGIN_NAME = "登录";
    public static final String LOGIN = "/person/account/login";

    public static final String LOGOUT_NAME = "登出";
    public static final String LOGOUT = "/person/account/logout";

    public static final String ACCOUNT_WXLOGIN_NAME = "登录";
    public static final String ACCOUNT_WXLOGIN = "/person/account/wxLogin";

    public static final String ACCOUNT_CHECKTRADEPASSWORD_NAME = "恒生登录";
    public static final String ACCOUNT_CHECKTRADEPASSWORD = "/person/tradePwd/check";

    public static final String ACCOUNT_QUERYUSERINFO_NAME = "获取用户信息";
    public static final String ACCOUNT_QUERYUSERINFO = "/person/query/queryUserInfo";

    public static final String QUERY_FUNDLIST_NAME = "查询基金列表";
    public static final String QUERY_FUNDLIST = "/global/fundList";

    public static final String QUERY_RECFUND_NAME = "查询推荐基金";
    public static final String QUERY_RECFUND = "/global/recfund";

    public static final String QUERY_QUERYFUNDMARKET_NAME = "查询基金行情";
    public static final String QUERY_QUERYFUNDMARKET = "/global/queryFundMarket";

    public static final String TRADE_BUYSMSAPPLY_NAME = "短信支付申请";
    public static final String TRADE_BUYSMSAPPLY = "/person/trade/buySmsApply";

    public static final String TRADE_BUYSMSCONFIRM_NAME = "短信支付验证";
    public static final String TRADE_BUYSMSCONFIRM = "/person/trade/buySmsConfirm";

    public static final String TRADE_BUY_NAME = "申购";
    public static final String TRADE_BUY = "/person/trade/buy";

    public static final String TRADE_REDEEM_NAME = "赎回";
    public static final String TRADE_REDEEM = "/person/trade/redeem";

    public static final String TRADE_TRANSFER_NAME = "转换";
    public static final String TRADE_TRANSFER = "/person/trade/transfer";

    public static final String TRADE_DIVIDEND_MODIFY_NAME = "修改分红方式";
    public static final String TRADE_DIVIDEND_MODIFY = "/person/trade/modifyDividend";

    public static final String TRADE_WITHDRAW_NAME = "撤单";
    public static final String TRADE_WITHDRAW = "/person/trade/cancelOrder";

    public static final String TRADE_HOPESALE_NAME = "预约赎回";
    public static final String TRADE_HOPESALE = "/person/trade/hopeSale";

    public static final String TRADE_HOPEBUY_NAME = "预约申购";
    public static final String TRADE_HOPEBUY = "/person/trade/hopeBuy";

    public static final String QUERY_WITHDRAWLIST_NAME = "可撤单列表";
    public static final String QUERY_WITHDRAWLIST = "/person/query/queryCancelOrderList";

    public static final String TRADE_PREPAREORDER_NAME = "查询可支付方式列表";
    public static final String TRADE_PREPAREORDER = "/trade/prepareOrder";

    public static final String QUERY_QUERYHOLDSHARE_NAME = "查询持有份额";
    public static final String QUERY_QUERYHOLDSHARE = "/person/query/queryShare";

    public static final String QUERY_QUERYREDEEMUSABLESHARE_NAME = "查询赎回可用份额";
    public static final String QUERY_QUERYREDEEMUSABLESHARE = "/person/query/queryRedeemUsableShare";

    public static final String QUERY_QUERYSPECIALSHARE_NAME = "查询专户份额";
    public static final String QUERY_QUERYSPECIALSHARE = "/person/query/querySpecialShare";

    public static final String QUERY_SHORTFUNDLIST_NAME = "查询短期理财列表";
    public static final String QUERY_SHORTFUNDLIST = "/person/query/shortFundList";

    public static final String QUERY_QUERYONWAYSHARE_NAME = "查询在途资产";
    public static final String QUERY_QUERYONWAYSHARE = "/person/query/queryOnWayShare";

    public static final String QUERY_QUERYHISTORYSHARE_NAME = "查询历史份额";
    public static final String QUERY_QUERYHISTORYSHARE = "/person/query/queryHoldShare";

    public static final String QUERY_PROFITLOSS_NAME = "查询盈亏s-104";
    public static final String QUERY_PROFITLOSS = "/person/query/profitLoss";

    public static final String QUERY_QUERYPROFITANDLOSSSUMMARY_NAME = "查询客户盈亏汇总信息s-111";
    public static final String QUERY_QUERYPROFITANDLOSSSUMMARY = "/person/query/queryProfitAndLossSummary";

    public static final String QUERY_QUERYCURRENTPROFITLOSS_NAME = "查询当前盈亏s-113";
    public static final String QUERY_QUERYCURRENTPROFITLOSS = "/person/query/queryCurrentProfitLoss";

    public static final String QUERY_QUERYPROFITCONSTRUCT_NAME = "收益构成s-202";
    public static final String QUERY_QUERYPROFITCONSTRUCT = "/person/query/queryProfitConstruct";

    public static final String QUERY_QUERYDIVIDENDLIST_NAME = "查询分红明细";
    public static final String QUERY_QUERYDIVIDENDLIST = "/person/query/queryDividendList";

    public static final String QUERY_QUERYTRADECONFIRM_NAME = "查询交易确认明细";
    public static final String QUERY_QUERYTRADECONFIRM = "/person/query/queryTradeConfirm";

    public static final String QUERY_QUERYUATRADECONFIRM_NAME = "查询交易确认明细UA";
    public static final String QUERY_QUERYUATRADECONFIRM = "/person/query/queryUaTradeConfirm";

    public static final String QUERY_PORTFOLIO_QUERYTRADEAPPLY_NAME = "历史交易申请记录查询（不包含组合)";
    public static final String QUERY_PORTFOLIO_QUERYTRADEAPPLY = "/person/queryTradeApplyExcludePortfolio";

    public static final String QUERY_PORTFOLIO_CONFIRMQUERY_NAME = "历史交易确认记录查询（不包含组合)";
    public static final String QUERY_PORTFOLIO_CONFIRMQUERY = "/person/query/tradeConfirmExcludePortfolio";

    public static final String QUERY_QUERYDAYTRADEINFOLIST_NAME = "携宁查询当日交易";
    public static final String QUERY_QUERYDAYTRADEINFOLIST = "/person/query/queryDayTradeInfoList";

    public static final String QUERY_QUERYTRADECONFIRMDATE_NAME = "查询确认日期";
    public static final String QUERY_QUERYTRADECONFIRMDATE = "/person/account/queryTradeConfirmDate";

    public static final String QUERY_QUERYFUNDRANK_NAME = "查询TOP基金";
    public static final String QUERY_QUERYFUNDRANK = "/person/query/queryFundRank";

    public static final String QUERY_QUERYTODOLIST_NAME = "待办事项查询";
    public static final String QUERY_QUERYTODOLIST = "/person/query/queryToDoList";

    public static final String ACCOUNT_MODIFYTODOLIST_NAME = "待办事项修改";
    public static final String ACCOUNT_MODIFYTODOLIST = "/person/account/modifyToDoList";

    public static final String TRADE_SAVETRACE_NAME = "保存留痕记录";
    public static final String TRADE_SAVETRACE = "/person/trade/saveTrace";

    public static final String TRADE_TRADEMESSAGE_NAME = "查询风险警示";
    public static final String TRADE_TRADEMESSAGE = "/person/trade/tradeWarningMessage";

    public static final String FIXTRADE_SEARCHFIXEDLIST_NAME = "查询定投协议列表I005";
    public static final String FIXTRADE_SEARCHFIXEDLIST = "/fixed/searchFixedList";

    public static final String FIXTRADE_ADDBUY_NAME = "定投申购协议新增I006";
    public static final String FIXTRADE_ADDBUY = "/fixed/addBuy";

    public static final String FIXTRADE_EDITPURCHASE_NAME = "定投申购协议变更I007";
    public static final String FIXTRADE_EDITPURCHASE = "/fixed/editPurchase";

    public static final String FIXTRADE_ADDCONVERSION_NAME = "新增定投转换I008";
    public static final String FIXTRADE_ADDCONVERSION = "/fixed/addConversion";

    public static final String FIXTRADE_EDITCONVERSION_NAME = "修改定投转换I009";
    public static final String FIXTRADE_EDITCONVERSION = "/fixed/editConversion";

    public static final String FIXTRADE_ADDREDEEM_NAME = "新增定投赎回";
    public static final String FIXTRADE_ADDREDEEM = "/fixed/addRedeem";

    public static final String FIXTRADE_EDITREDEEM_NAME = "修改定投赎回I011";
    public static final String FIXTRADE_EDITREDEEM = "/fixed/editRedeem";

    public static final String FIXTRADE_QUERYFIXFUNDINFOLIST_NAME = "可定投申购的基金列表I012";
    public static final String FIXTRADE_QUERYFIXFUNDINFOLIST = "/person/query/queryFixFundInfoList";

    public static final String FIXTRADE_QUERYFIXTRANSFERFUNDINFOLIST_NAME = "可定投转换的转入基金列表I013";
    public static final String FIXTRADE_QUERYFIXTRANSFERFUNDINFOLIST = "/person/query/queryFixTransferFundInfoList";

    public static final String HOPETRADE_QUERYUNDEALHOPETRADELIST_NAME = "未处理预约申请列表";
    public static final String HOPETRADE_QUERYUNDEALHOPETRADELIST = "/person/query/queryUnDealHopeTradeList";

    public static final String HOPETRADE_HOPEPREPAREBUY_NAME = "预约买入支付方式列表";
    public static final String HOPETRADE_HOPEPREPAREBUY = "/person/query/hopePrepareBuy";

    public static final String HOPETRADE_HOPEPREPARESALE_NAME = "预约卖出支付方式列表";
    public static final String HOPETRADE_HOPEPREPARESALE = "/person/query/hopePrepareSale";

    public static final String QUERY_EXPONENTVALUE_NAME = "指数查询";
    public static final String QUERY_EXPONENTVALUE = "/person/query/queryExponentValue";

    public static final String ACCOUNT_BINDINFO_NAME = "查询绑定用户信息";
    public static final String ACCOUNT_BINDINFO = "/person/account/bindInfo";

    public static final String ACCOUNT_QUERYBINDINFO_NAME = "查询用户绑定信息";
    public static final String ACCOUNT_QUERYBINDINFO = "/person/account/queryBindInfo";

    public static final String ACCOUNT_BIND_NAME = "绑定用户信息";
    public static final String ACCOUNT_BIND = "/person/account/bind";

    public static final String ACCOUNT_UNBIND_NAME = "解绑用户信息";
    public static final String ACCOUNT_UNBIND = "/person/account/unBind";

    public static final String ACCOUNT_CREATEUSER_NAME = "创建用户";
    public static final String ACCOUNT_CREATEUSER = "/person/account/createUser";

    public static final String ACCOUNT_MODIFYUSERINFO_NAME = "修改用户信息";
    public static final String ACCOUNT_MODIFYUSERINFO = "/person/account/modifyUserInfo";

    public static final String ACCOUNT_AUTHLOGINPWD_NAME = "认证";
    public static final String ACCOUNT_AUTHLOGINPWD = "/person/account/authLoginPwd";


    public static final String ACCOUNT_SMSAPPLY_NAME = "短信验证申请";
    public static final String ACCOUNT_SMSAPPLY = "/account/smsApply";

    public static final String ACCOUNT_SMSCONFIRM_NAME = "短信验证";
    public static final String ACCOUNT_SMSCONFIRM = "/account/smsConfirm";


    public static final String ACCOUNT_MODIFYPASSWORD_NAME = "修改登录密码";
    public static final String ACCOUNT_MODIFYPASSWORD = "/person/account/modifyLoginPwd";

    public static final String ACCOUNT_RESETPASSWORDREQUEST_NAME = "重置登录密码申请";
    public static final String ACCOUNT_RESETPASSWORDREQUEST = "/person/account/resetLoginPwdApply";

    public static final String ACCOUNT_RESETPASSWORD_NAME = "重置登录密码";
    public static final String ACCOUNT_RESETPASSWORD = "/person/account/resetLoginPwd";

    public static final String ACCOUNT_RISKQUERY_NAME = "获取风险评测题目及答案";
    public static final String ACCOUNT_RISKQUERY = "/person/account/riskQuery";

    public static final String ACCOUNT_RISKMODIFY_NAME = "提交风险评测答案";
    public static final String ACCOUNT_RISKMODIFY = "/person/account/riskModify";

    public static final String ACCOUNT_VALCUSTOMER_NAME = "检查是否携宁开户的用户 ";
    public static final String ACCOUNT_VALCUSTOMER = "/person/query/valcustomer";

    public static final String ACCOUNT_OPEN_BANKLIST_NAME = "开户银行卡列表";
    public static final String ACCOUNT_OPEN_BANKLIST = "/person/account/bankList";

    public static final String ACCOUNT_OPEN_PREPARE_NAME = "开户准备";
    public static final String ACCOUNT_OPEN_PREPARE = "/person/account/prepare";

    public static final String ACCOUNT_OPEN_VERIFICATION_NAME = "开户验证";
    public static final String ACCOUNT_OPEN_VERIFICATION = "/person/account/verification";

    public static final String ACCOUNT_OPEN_NAME = "开户";
    public static final String ACCOUNT_OPEN = "/person/account/open";

    public static final String BANK_DELETE_NAME = "删除银行卡";
    public static final String BANK_DELETE = "/person/account/bankDelete";

    public static final String BANK_CANSIGNLIST_NAME = "可签约银行卡列表I001";
    public static final String BANK_CANSIGNLIST = "/person/account/bankCanSignList";

    public static final String BANK_ALLINPAYSIGNPREPARE_NAME = "银行卡签约准备";
    public static final String BANK_ALLINPAYSIGNPREPARE = "/person/account/allInPaySignPrepare";

    public static final String BANK_SIGN_NAME = "银行卡签解约";
    public static final String BANK_SIGN = "/person/account/allInPaySign";

    public static final String BANK_BANKMODIFYFULLNAME_NAME = "修改银行卡名称";
    public static final String BANK_BANKMODIFYFULLNAME = "/person/account/bankModifyFullName";

    public static final String QUERY_QUERYTRADEACCOINFOLIST_NAME = "查询交易账号信息";
    public static final String QUERY_QUERYTRADEACCOINFOLIST = "/person/query/queryTradeAccoInfoList";

    public static final String QUERY_CANTRANSFERFUNDLIST_NAME = "可转换目标基金代码";
    public static final String QUERY_CANTRANSFERFUNDLIST = "/person/query/canTransferFundList";


    public static final String PORTFOLIO_PORTFOLIOFINDINFO_NAME = "组合信息查询";
    public static final String PORTFOLIO_PORTFOLIOFINDINFO = "/global/queryPortfolio";


    public static final String PORTFOLIO_COMBINVESTORDER_NAME = "可组合投资支付方式列表(T014)";
    public static final String PORTFOLIO_COMBINVESTORDER = "/person/portfolio/combInvestOrder";

    public static final String PORTFOLIO_PORTFOLIOHISTORY_NAME = "组合调仓查询";
    public static final String PORTFOLIO_PORTFOLIOHISTORY = "/portfolio/portfolioHistory";


    public static final String PORTFOLIO_PORTFOLIOBUY_NAME = "组合申购";
    public static final String PORTFOLIO_PORTFOLIOBUY = "/person/portfolio/buy";

    public static final String PORTFOLIO_PORTFOLIOTRADEAPPLY_NAME = "组合交易记录查询";
    public static final String PORTFOLIO_PORTFOLIOTRADEAPPLY = "/person/portfolio/queryTradeRecord";

    public static final String PORTFOLIO_PORTFOLIOTRADEAPPLYDETAIL_NAME = "组合交易明细记录查询";
    public static final String PORTFOLIO_PORTFOLIOTRADEAPPLYDETAIL = "/person/portfolio/queryTradeRecordDetail";

    public static final String PORTFOLIO_PORTFOLIOWITHDRAWLIST_NAME = "组合可撤单记录查询";
    public static final String PORTFOLIO_PORTFOLIOWITHDRAWLIST = "/person/portfolio/withDrawList";

    public static final String PORTFOLIO_PORTFOLIOWITHDRAW_NAME = "组合撤单";
    public static final String PORTFOLIO_PORTFOLIOWITHDRAW = "/person/portfolio/withDraw";

    public static final String PORTFOLIO_QUERYPORTFOLIOASSETS_NAME = "组合资产查询";
    public static final String PORTFOLIO_QUERYPORTFOLIOASSETS = "/person/portfolio/queryAssets";

    public static final String PORTFOLIO_QUERYPORTFOLIOASSETSDETAIL_NAME = "组合资产明细查询";
    public static final String PORTFOLIO_QUERYPORTFOLIOASSETSDETAIL = "/person/portfolio/queryAssetDetail";

    public static final String PORTFOLIO_QUERYPORTFOLIOTOTALASSETS_NAME = "组合总资产查询";
    public static final String PORTFOLIO_QUERYPORTFOLIOTOTALASSETS = "/person/portfolio/queryTotalAssets";

    public static final String PORTFOLIO_PORTFOLIOREDEEM_NAME = "组合赎回";
    public static final String PORTFOLIO_PORTFOLIOREDEEM = "/person/portfolio/redeem";

    public static final String PORTFOLIO_PORTFOLIOADJUSTMENT_NAME = "组合调仓";
    public static final String PORTFOLIO_PORTFOLIOADJUSTMENT = "/person/portfolio/adjustment";

    public static final String PORTFOLIO_PORTFOLIODIVIDEND_NAME = "组合分红查询";
    public static final String PORTFOLIO_PORTFOLIODIVIDEND = "/person/portfolio/queryDividend";

    public static final String PORTFOLIO_PORTFOLIODIVIDENDSUM_NAME = "组合分红汇总查询";
    public static final String PORTFOLIO_PORTFOLIODIVIDENDSUM = "/person/portfolio/queryDividendSum";

    public static final String PORTFOLIO_QUERYPORTFOLIOTOTALINCOME_NAME = "查询组合总盈亏";
    public static final String PORTFOLIO_QUERYPORTFOLIOTOTALINCOME = "/person/portfolio/queryTotalProfitLoss";

    public static final String PORTFOLIO_PORTFOLIOPROFITLOSS_NAME = "组合盈亏查询";
    public static final String PORTFOLIO_PORTFOLIOPROFITLOSS = "/person/portfolio/queryProfitLoss";

    public static final String PORTFOLIO_STRATEGYINCOME_NAME = "策略行情";
    public static final String PORTFOLIO_STRATEGYINCOME = "/global/queryStrategyIncome";

    public static final String PORTFOLIO_PORTFOLIOINCOME_NAME = "组合行情查询";
    public static final String PORTFOLIO_PORTFOLIOINCOME = "/global/queryPortfolioIncome";

    public static final String SPECIAL_SIGNECONTRACT_NAME = "签署电子合同或风险揭示书";
    public static final String SPECIAL_SIGNECONTRACT = "/person/trade/signEconTract";

    public static final String SPECIAL_QUERYECONTRACT_NAME = "查询电子合同信息";
    public static final String SPECIAL_QUERYECONTRACT = "/person/query/queryEconTract";

    public static final String SPECIAL_QUERYSPECIALFUNDREPORT_NAME = "查询高端理财公告年报";
    public static final String SPECIAL_QUERYSPECIALFUNDREPORT = "/global/queryFundReport";

    public static final String QUERY_UATRADEFARE_NAME = "统一账户查询交易费率";
    public static final String QUERY_UATRADEFARE = "/person/query/uaTradeFare";

    public static final String QUERY_QUERYDIAGRESULT_NAME = "基金账户诊断";
    public static final String QUERY_QUERYDIAGRESULT = "/person/query/queryDiagResult";

    public static final String FILE_UPLOADIMAGEPERSONAL_NAME = "上传图片";
    public static final String FILE_UPLOADIMAGEPERSONAL = "/file/uploadImagePersonal";

    public static final String PORTFOLIO_RISK_QUERYQUESTIONANDANSWER_NAME = "获取天玑智投风险评测题目及答案";
    public static final String PORTFOLIO_RISK_QUERYQUESTIONANDANSWER = "/person/queryDiagnose";

    public static final String PORTFOLIO_RISK_SAVERISKRESULT_NAME = "提交天玑智投风险评测";
    public static final String PORTFOLIO_RISK_SAVERISKRESULT = "/person/saveDiagnose";

    public static final String PORTFOLIO_RISK_PORTFOLIORISKRESULT_NAME = "获取天玑智投风险评测结果";
    public static final String PORTFOLIO_RISK_PORTFOLIORISKRESULT = "/person/queryDiagnoseRiskLevel";

    public static final String GLOBAL_QUERYTRADEACCOLIST_NAME = "离线查询交易账号列表";
    public static final String GLOBAL_QUERYTRADEACCOLIST = "/global/queryTradeAccoList";

    public static final String GLOBAL_QUERYUSERINFOBYSK_NAME = "查询用户信息通过sk";
    public static final String GLOBAL_QUERYUSERINFOBYSK = "/global/queryUserInfoBySk";


    public static final String ACCOUNT_RESETTRADEPWDPRE_NAME = "重置交易密码前判断";
    public static final String ACCOUNT_RESETTRADEPWDPRE = "/person/tradePwd/resetPrepare";

    public static final String ACCOUNT_RESETPREPARESECOND_NAME = "重置交易密码前判断第二步";
    public static final String ACCOUNT_RESETPREPARESECOND = "/person/tradePwd/resetPrepareSecond";

    public static final String ACCOUNT_TRADEPASSWORDCHECK_NAME = "验证交易密码";
    public static final String ACCOUNT_TRADEPASSWORDCHECK = "/person/tradePwd/check";

    public static final String ACCOUNT_CREATEANDUPDATERESETTRADEPWD_NAME = "创建及修改重置交易密码流转单";
    public static final String ACCOUNT_CREATEANDUPDATERESETTRADEPWD = "/person/tradePwd/createAndUpdateReset";

    public static final String ACCOUNT_SELFRESETBANKLIST_NAME = "查询可自助重置交易密码的银行卡列表";
    public static final String ACCOUNT_SELFRESETBANKLIST = "/person/tradePwd/resetBankList";

    public static final String ACCOUNT_SELFRESETBANKSIGN_NAME = "自助重置交易密码-银行签名";
    public static final String ACCOUNT_SELFRESETBANKSIGN = "/person/tradePwd/getBankSign";

    public static final String ACCOUNT_SELFRESETCHECKSIGN_NAME = "自助重置交易密码-验证签名";
    public static final String ACCOUNT_SELFRESETCHECKSIGN = "/person/tradePwd/verifyIdentity";

    public static final String ACCOUNT_SELFRESETSENDCODE_NAME = "自助重置交易密码-发送验证码";
    public static final String ACCOUNT_SELFRESETSENDCODE = "/person/tradePwd/bankSendAuthCode";

    public static final String ACCOUNT_SELFRESETCHECKCODE_NAME = "自助重置交易密码-验证验证码";
    public static final String ACCOUNT_SELFRESETCHECKCODE = "/person/tradePwd/bankVerifyAuthCode";

    public static final String ACCOUNT_SELFRESET_NAME = "自助重置交易密码-重置";
    public static final String ACCOUNT_SELFRESET = "/person/tradePwd/reset";

    public static final String ACCOUNT_CHANGEBANKCARDPRE_NAME = "换卡前判断";
    public static final String ACCOUNT_CHANGEBANKCARDPRE = "/person/account/changeBankCardPrepare";

    public static final String ACCOUNT_CHANGEBANKCARDPREPARESECOND_NAME = "换卡前判断第二步（是否自助";
    public static final String ACCOUNT_CHANGEBANKCARDPREPARESECOND = "/person/account/changeBankCardPrepareSecond";

    public static final String ACCOUNT_CREATEANDUPDATECHGBANKCARD_NAME = "创建及修改换卡流转单";
    public static final String ACCOUNT_CREATEANDUPDATECHGBANKCARD = "/person/account/createAndUpdateChangeBankCardReq";

    public static final String ACCOUNT_SELFCHANGECARD_NAME = "自助更换银行卡";
    public static final String ACCOUNT_SELFCHANGECARD = "/person/account/bankModifyInfo";

    public static final String SERVICECUSTOM_MSGSENDSERVICE_NAME = "消息发送";
    public static final String SERVICECUSTOM_MSGSENDSERVICE = "/person/query/msgSendService";

    public static final String SERVICECUSTOM_SERVICEQUERY_NAME = "订阅服务查询";
    public static final String SERVICECUSTOM_SERVICEQUERY = "/person/subService/query";

    public static final String SERVICECUSTOM_SUBSCRIBESERVICE_NAME = "服务订阅";
    public static final String SERVICECUSTOM_SUBSCRIBESERVICE = "/person/subService/subscribe";

    public static final String SERVICECUSTOM_TRUSTEESHIPPRE_NAME = "转托管前判断";
    public static final String SERVICECUSTOM_TRUSTEESHIPPRE = "/person/trusteeship/prepare";

    public static final String SERVICECUSTOM_CREATETRUSTEESHIP_NAME = "创建转托管流转单";
    public static final String SERVICECUSTOM_CREATETRUSTEESHIP = "/person/trusteeship/create";

    public static final String SERVICECUSTOM_UPDATETRUSTEESHIP_NAME = "修改转托管流转单";
    public static final String SERVICECUSTOM_UPDATETRUSTEESHIP = "/person/trusteeship/update";

    public static final String SERVICECUSTOM_REFUNDPRE_NAME = "退款重划前判断";
    public static final String SERVICECUSTOM_REFUNDPRE = "/person/refund/prepare";

    public static final String SERVICECUSTOM_CREATEREFUND_NAME = "创建退款重划流转单";
    public static final String SERVICECUSTOM_CREATEREFUND = "/person/refund/create";

    public static final String SERVICECUSTOM_ASSETSPRE_NAME = "资产证明前判断";
    public static final String SERVICECUSTOM_ASSETSPRE = "/person/assets/prepare";

    public static final String SERVICECUSTOM_CREATEASSETS_NAME = "创建资产证明流转单";
    public static final String SERVICECUSTOM_CREATEASSETS = "/person/assets/create";

    public static final String SERVICECUSTOM_ASSETSQUERYRECORD_NAME = "资产证明申请记录查询";
    public static final String SERVICECUSTOM_ASSETSQUERYRECORD = "/person/assets/queryRecord";

    public static final String SERVICECUSTOM_REFUNDQUERYRECORD_NAME = "退款重划申请记录查询";
    public static final String SERVICECUSTOM_REFUNDQUERYRECORD = "/person/refund/queryServerRecord";

    public static final String VERSION_GETVERSION_NAME = "查询版本";
    public static final String VERSION_GETVERSION = "/version/getVersion";

    /**
     * 查询交易申请
     */
    public static final String QUERY_TRADE_APPLY = "/person/queryTradeApplyExcludePortfolio";
    public static final String QUERY_TRADE_APPLY_NAME = "查询交易申请";

    /**
     * 查询交易申请
     */
    public static final String QUERY_DIVIDEND_EXCLUDEPORTFOLIO = "/person/queryTradeApplyExcludePortfolio";
    public static final String QUERY_DIVIDEND_EXCLUDEPORTFOLIO_NAME = "查询交易申请";

    /**
     * 查询交易确认
     */
    public static final String QUERY_TRADE_CONFIRM_NAME = "查询交易确认";
    public static final String QUERY_TRADE_CONFIRM = "/person/query/queryTradeConfirm";

    /**
     * 查询交易确认
     */
    public static final String QUERY_TRADE_REQUEST_NAME = "查询历史交易申请";
    public static final String QUERY_TRADE_REQUEST = "/person/query/tradeRequest";

    /**
     * 查询交易确认
     */
    public static final String TRADE_CONFIRMORDER_NAME = "支付结果通知";
    public static final String TRADE_CONFIRMORDER = "/person/trade/confirmOrder";


    /**
     * 发送短信
     */
    public static final String GLOBAL_SEND_SMS_NAME = "发送短信";
    public static final String GLOBAL_SEND_SMS = "/global/sendVerCode";

    public static final String GLOBAL_CHECK_SMS_NAME = "验证短信验证码";
    public static final String GLOBAL_CHECK_SMS = "/global/checkVerCode";

    public static final String GLOBAL_SEND_EMAIL_NAME = "发送邮件";
    public static final String GLOBAL_SEND_EMAIL = "/global/emailSend";

    /**
     * 高端理财模块
     */
    public static final String GLOBAL_QUERY_SPECIAL_FUND_LIST_NAME = "查询高端理财基金产品列表";
    public static final String GLOBAL_QUERY_SPECIAL_FUND_LIST = "/global/querySpecialFundList";

    public static final String GLOBAL_QUERY_SPECIAL_FUND_INFO_NAME = "查询高端理财基金产品信息";
    public static final String GLOBAL_QUERY_SPECIAL_FUND_INFO = "/global/querySpecialFundInfo";

    public static final String GLOBAL_SPECIAL_QUERYSPECIALREMAINAMOUNT_NAME = "查询高端理财剩余额度";
    public static final String GLOBAL_SPECIAL_QUERYSPECIALREMAINAMOUNT = "/person/query/specialRemainAmount";

    /**
     * 最新动态
     */
    public static final String ACCOUNT_NEWS_INFO_NAME = "查询首页最新动态";
    public static final String ACCOUNT_NEWS_INFO = "/person/account/queryNewsInfoList";

    /**
     * 鸡汤
     */
    public static final String ACCOUNT_SOUL_SOOTHER_INFO_NAME = "查询鸡汤";
    public static final String ACCOUNT_SOUL_SOOTHER_INFO = "/person/account/querySoulSootherInfoList";

    /**
     * 横幅
     */
    public static final String ACCOUNT_BANNER_INFO_NAME = "查询横幅";
    public static final String ACCOUNT_BANNER_INFO = "/person/account/queryBannerInfoList";

    public static final String QUERY_SUPERMONEYSHARE_NAME = "超级现金宝份额查询";
    public static final String QUERY_SUPERMONEYSHARE = "/person/query/querySuperMoneyShare";
    public static final String QUERY_SUPERMONEYINCOME_NAME = "超级现金宝收益查询";
    public static final String QUERY_SUPERMONEYINCOME = "/person/query/querySuperMoneyIncome";
    public static final String QUERY_SUPERMONEYTRADEREQUEST_NAME = "超级现金宝交易申请查询";
    public static final String QUERY_SUPERMONEYTRADEREQUEST = "/person/query/querySuperMoneyTradeRequest";
    public static final String QUERY_SUPERMONEYFUNDMARKET_NAME = "超级现金宝行情查询";
    public static final String QUERY_SUPERMONEYFUNDMARKET = "/person/query/querySuperMoneyFundMarket";

    /**
     * 银行卡升位
     */
    public static final String ACCOUNT_CHANGE_BANK_ID_CARD_NAME = "银行卡身份证升位";
    public static final String ACCOUNT_CHANGE_BANK_ID_CARD = "/person/account/changeBankIdCard";

    public static final String ACCOUNT_ID_CARD_UPDATE_NAME = "用户信息身份证升位";
    public static final String ACCOUNT_ID_CARD_UPDATE = "/person/account/idCardUpdate";

    /**
     * 修改交易密码
     */
    public static final String ACCOUNT_MODIFY_TRADE_PWD_NAME = "修改交易密码";
    public static final String ACCOUNT_MODIFY_TRADE_PWD = "/person/tradePwd/modify";

    public static final String ACCOUNT_GET_USER_TODO_STATE_NAME = "获取代办事项屏蔽";
    public static final String ACCOUNT_GET_USER_TODO_STATE = "/person/account/getUserToDoState";

    public static final String ACCOUNT_UPDATE_USER_TODO_STATE_NAME = "更新代办事项屏蔽";
    public static final String ACCOUNT_UPDATE_USER_TODO_STATE = "/person/account/updateUserToDoState";

    public static final String QUERY_MODIFY_DIVIDEND_LIST_NAME = "查询可修改分红方式列表";
    public static final String QUERY_MODIFY_DIVIDEND_LIST = "/person/query/queryModifyDividendList";

    public static final String TRADE_ISALLINPAYCHANGECARD_NAME = "判断是否通联换卡";
    public static final String TRADE_ISALLINPAYCHANGECARD = "/person/trade/changeCard";

    public static final String ACCOUNT_BANKSIGN_NAME = "签解约";
    public static final String ACCOUNT_BANKSIGN = "/person/account/bankSign";
    /**
     * 成功代码
     */
    public static final String SUCCESS_CODE = "00000000";

    public static final String ACCOUNT_RISE_IDENTITY_NO_NAME = "身份证升位";
    public static final String ACCOUNT_RISE_IDENTITY_NO = "/person/account/riseIdentityNo";

    public static final String ACCOUNT_DIRECT_BANK_SIGN_PREPARE_NAME = "银华重新签约准备";
    public static final String ACCOUNT_DIRECT_BANK_SIGN_PREPARE = "/person/account/directBankSignPrepare";

    public static final String ACCOUNT_DIRECT_BANK_SIGN_VERIFICATION_NAME = "银华重新签约验证";
    public static final String ACCOUNT_DIRECT_BANK_SIGN_VERIFICATION = "/person/account/directBankSignVerification";

    public static final String PORTFOLIO_QUERY_INCOMERATE = "/global/queryPortfolioIncomeRate";
    public static final String PORTFOLIO_QUERY_INCOMERATE_NAME = "查询组合收益率";

    public static final String FIXED_QUERY_EXPONENTVALUE = "/fixed/queryExponentValue";
    public static final String FIXED_QUERY_EXPONENTVALUE_NAME = "查询指数值";

    public static final String PORTFOLIO_QUERYASSETSDETAILANDDIVIDEND_NAME = "组合资产明细查询";
    public static final String PORTFOLIO_QUERYASSETSDETAILANDDIVIDEND = "/person/portfolio/queryAssetDetailAndDividend";

    public static final String QUERY_TRADEECKPENSIONUSER_NAME = "是否可以进行养老金问卷";
    public static final String QUERY_TRADEECKPENSIONUSER = "/person/trade/checkPensionUser";

    public static final String SAVE_TRADEVEPENSIONUSER_NAME = "养老金答题";
    public static final String SAVE_TRADEVEPENSIONUSER = "/person/trade/savePensionUser";

    public static final String QUERYPENSIONSHARELISTSUB_NAME = "养老金可赎回份额";
    public static final String QUERYPENSIONSHARELISTSUB = "/person/query/pensionShareList";

    public static final String PENSION_PORTFOLIO_COMMEND_NAME = "养老组合推荐";
    public static final String PENSION_PORTFOLIO_COMMEND = "/global/advance/calculator";

    public static final String QUERY_ACCOUNT_RECORD_NAME = "交易对账单-账户查询";
    public static final String QUERY_ACCOUNT_RECORD = "/person/query/accountRecord";

    public static final String CALCULATOR_CITY = "/global/advance/calculatorCity";
    public static final String CALCULATOR_CITY_NAME = "查询养老金地址城市信息";

    public static final String QUERY_ACCOMPANY = "/person/query/queryFundAccompany";
    public static final String QUERY_ACCOMPANY_NAME = "查询基金伴随信息";

    public static final String QUERY_TOP_THREE = "/global/topNFund";
    public static final String QUERY_TOP_THREE_NAME ="查询镇店之宝";

    /**
     * 文件服务器地址
     */
    public static String PERSON_YHFUND_FILE_SERVER;
    /**
     * 文件服务器地址
     */
    public static String PERSON_OSSYHFUND_FILE_SERVER;
    static {
        Properties pro = new Properties();
        InputStream in = MiddlewareServiceConstans.class.getResourceAsStream("/middlewareService.properties");
        try {
            pro.load(new InputStreamReader(in, "UTF-8"));

            PERSON_YHFUND_FILE_SERVER = pro.getProperty("yhfund.file.server");
            PERSON_OSSYHFUND_FILE_SERVER = pro.getProperty("oss.yhfund.file.server");
            PARAM_FORMAT = pro.getProperty("param.format");
            PARAM_MERID = pro.getProperty("param.merid");
            PARAM_CHANNEL = pro.getProperty("param.channel");
            PARAM_USERTYPE = pro.getProperty("param.usertype");
            PARAM_SIGNMODE = pro.getProperty("param.signmode");
            PARAM_SIGNMSG = pro.getProperty("param.signmsg");
            PARAM_CUSTTRUST = pro.getProperty("param.custtrust");
            PARAM_VERSION = pro.getProperty("param.version");
            PARAM_AZ_APPID = pro.getProperty("param.az.appid");
            PARAM_ORGCHANNEL = pro.getProperty("param.orgchannel");

            AES_KEY = pro.getProperty("param.aeskey");

            SUCCESS = pro.getProperty("result.success");
            MIDDLEWARE_SERVER_ROOT_PATH = pro.getProperty("middleware.server.root.path");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

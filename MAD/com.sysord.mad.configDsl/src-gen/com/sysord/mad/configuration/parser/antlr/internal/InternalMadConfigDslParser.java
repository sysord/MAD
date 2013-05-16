package com.sysord.mad.configuration.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.sysord.mad.configuration.services.MadConfigDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMadConfigDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'from plugin'", "'label:'", "'='", "'+'", "'Use icon'", "'description:'", "'location:'", "'URI:'", "'Use I18N Bundle'", "'Foreign Model'", "'{'", "'model type:'", "'synchronizer factory'", "':'", "'extension manager'", "'model locator:'", "'}'", "'Uri Extension:'", "'Model Uri:'", "'Provider Class:'", "'parameters:'", "','", "'Xtext DSL:'", "'language Id:'", "'from bundle:'", "'with activator:'", "'DSL:'", "'Custom OCL Library'", "'Class:'", "'Query Evaluator'", "'language id:'", "'Evaluator'", "'query Properties type:'", "'external query provider:'", "'Widget type'", "'name:'", "'category:'", "'custom widget:'", "'UI'", "'Tab'", "'id:'", "'I18N'", "'Layer'", "'Sub'", "'layers'", "'DEFAULT'", "'Configuration'", "'for'", "'label provider:'", "'extends:'", "'template:'", "'layout:'", "'include widget:'", "'source template:'", "'value:'", "'Query'", "'widget:'", "'tab:'", "'layers:'", "'type:'", "'flexible template:'", "'target template:'", "'visible when:'", "'editable when:'", "'valueConverter:'", "'validators:'", "'format:'", "'candidates:'", "'item label:'", "'commands:'", "'validation rule:'", "'Error message:'", "'Common Command'", "'icon:'", "'action:'", "'on success:'", "'on error:'", "'('", "')'", "'Display view'", "'Reload'", "'view'", "'widgets:'", "'Common Query'", "'language:'", "'foreign model:'", "'context locator:'", "'properties:'", "'Optimisation:'", "'call'", "'()'", "'Query Chain'", "'Macro:'", "'#'", "'DATE'", "'DATETIME'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'XTEXT'", "'OUTPUTTEXT_WIDGET'", "'NAVIGATION_WIDGET'", "'TEXT_WIDGET'", "'BOOL_WIDGET'", "'DATE_WIDGET'", "'NUMBER_WIDGET'", "'SINGLE_SELECT_WIDGET'", "'MULTI_SELECT_WIDGET'", "'XTEXT_EDITOR'", "'XTEXT_TEXT_EDITOR'", "'FLEXIBLE_WIDGET'", "'UPDATE_COMMAND'", "'GLOBAL_COMMAND'", "'ITEM_COMMAND'", "'NONE'", "'VIEW'", "'CONTEXT'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int RULE_STRING=4;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalMadConfigDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMadConfigDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMadConfigDslParser.tokenNames; }
    public String getGrammarFileName() { return "../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g"; }



     	private MadConfigDslGrammarAccess grammarAccess;
     	
        public InternalMadConfigDslParser(TokenStream input, MadConfigDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MADConfiguration";	
       	}
       	
       	@Override
       	protected MadConfigDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMADConfiguration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:68:1: entryRuleMADConfiguration returns [EObject current=null] : iv_ruleMADConfiguration= ruleMADConfiguration EOF ;
    public final EObject entryRuleMADConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMADConfiguration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:69:2: (iv_ruleMADConfiguration= ruleMADConfiguration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:70:2: iv_ruleMADConfiguration= ruleMADConfiguration EOF
            {
             newCompositeNode(grammarAccess.getMADConfigurationRule()); 
            pushFollow(FOLLOW_ruleMADConfiguration_in_entryRuleMADConfiguration75);
            iv_ruleMADConfiguration=ruleMADConfiguration();

            state._fsp--;

             current =iv_ruleMADConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMADConfiguration85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMADConfiguration"


    // $ANTLR start "ruleMADConfiguration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:77:1: ruleMADConfiguration returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* ) ;
    public final EObject ruleMADConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_configElements_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:80:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:82:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:82:1: (lv_imports_0_0= ruleImport )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:83:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMADConfigurationAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMADConfiguration131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMADConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:99:3: ( (lv_configElements_1_0= ruleMADConfigElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16||(LA2_0>=20 && LA2_0<=21)||LA2_0==34||LA2_0==39||LA2_0==41||LA2_0==46||LA2_0==50||LA2_0==54||(LA2_0>=57 && LA2_0<=58)||LA2_0==84||LA2_0==95||LA2_0==104) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:100:1: (lv_configElements_1_0= ruleMADConfigElement )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:100:1: (lv_configElements_1_0= ruleMADConfigElement )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:101:3: lv_configElements_1_0= ruleMADConfigElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMADConfigurationAccess().getConfigElementsMADConfigElementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMADConfigElement_in_ruleMADConfiguration153);
            	    lv_configElements_1_0=ruleMADConfigElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMADConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configElements",
            	            		lv_configElements_1_0, 
            	            		"MADConfigElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMADConfiguration"


    // $ANTLR start "entryRuleMADConfigElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:125:1: entryRuleMADConfigElement returns [EObject current=null] : iv_ruleMADConfigElement= ruleMADConfigElement EOF ;
    public final EObject entryRuleMADConfigElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMADConfigElement = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:126:2: (iv_ruleMADConfigElement= ruleMADConfigElement EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:127:2: iv_ruleMADConfigElement= ruleMADConfigElement EOF
            {
             newCompositeNode(grammarAccess.getMADConfigElementRule()); 
            pushFollow(FOLLOW_ruleMADConfigElement_in_entryRuleMADConfigElement190);
            iv_ruleMADConfigElement=ruleMADConfigElement();

            state._fsp--;

             current =iv_ruleMADConfigElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMADConfigElement200); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMADConfigElement"


    // $ANTLR start "ruleMADConfigElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:134:1: ruleMADConfigElement returns [EObject current=null] : (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl ) ;
    public final EObject ruleMADConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_LayerMdsl_0 = null;

        EObject this_ForeignModelMdsl_1 = null;

        EObject this_XtextLanguageDescriptorMdsl_2 = null;

        EObject this_QueryEvaluatorMdsl_3 = null;

        EObject this_OCLCustomLibraryMdsl_4 = null;

        EObject this_QueryDeclaration_5 = null;

        EObject this_WidgetType_6 = null;

        EObject this_UITabMdsl_7 = null;

        EObject this_CommandDeclaration_8 = null;

        EObject this_TypeConfigurationMdsl_9 = null;

        EObject this_TextMacro_10 = null;

        EObject this_I18NBundleMdsl_11 = null;

        EObject this_IconDescriptorMdsl_12 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:137:28: ( (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 34:
                {
                alt3=3;
                }
                break;
            case 41:
                {
                alt3=4;
                }
                break;
            case 39:
                {
                alt3=5;
                }
                break;
            case 95:
                {
                alt3=6;
                }
                break;
            case 46:
                {
                alt3=7;
                }
                break;
            case 50:
                {
                alt3=8;
                }
                break;
            case 84:
                {
                alt3=9;
                }
                break;
            case 57:
            case 58:
                {
                alt3=10;
                }
                break;
            case 104:
                {
                alt3=11;
                }
                break;
            case 20:
                {
                alt3=12;
                }
                break;
            case 16:
                {
                alt3=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:139:5: this_LayerMdsl_0= ruleLayerMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getLayerMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLayerMdsl_in_ruleMADConfigElement247);
                    this_LayerMdsl_0=ruleLayerMdsl();

                    state._fsp--;

                     
                            current = this_LayerMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:149:5: this_ForeignModelMdsl_1= ruleForeignModelMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getForeignModelMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleForeignModelMdsl_in_ruleMADConfigElement274);
                    this_ForeignModelMdsl_1=ruleForeignModelMdsl();

                    state._fsp--;

                     
                            current = this_ForeignModelMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:159:5: this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getXtextLanguageDescriptorMdslParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleXtextLanguageDescriptorMdsl_in_ruleMADConfigElement301);
                    this_XtextLanguageDescriptorMdsl_2=ruleXtextLanguageDescriptorMdsl();

                    state._fsp--;

                     
                            current = this_XtextLanguageDescriptorMdsl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:169:5: this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getQueryEvaluatorMdslParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleQueryEvaluatorMdsl_in_ruleMADConfigElement328);
                    this_QueryEvaluatorMdsl_3=ruleQueryEvaluatorMdsl();

                    state._fsp--;

                     
                            current = this_QueryEvaluatorMdsl_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:179:5: this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getOCLCustomLibraryMdslParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleOCLCustomLibraryMdsl_in_ruleMADConfigElement355);
                    this_OCLCustomLibraryMdsl_4=ruleOCLCustomLibraryMdsl();

                    state._fsp--;

                     
                            current = this_OCLCustomLibraryMdsl_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:189:5: this_QueryDeclaration_5= ruleQueryDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getQueryDeclarationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement382);
                    this_QueryDeclaration_5=ruleQueryDeclaration();

                    state._fsp--;

                     
                            current = this_QueryDeclaration_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:199:5: this_WidgetType_6= ruleWidgetType
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getWidgetTypeParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleWidgetType_in_ruleMADConfigElement409);
                    this_WidgetType_6=ruleWidgetType();

                    state._fsp--;

                     
                            current = this_WidgetType_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:209:5: this_UITabMdsl_7= ruleUITabMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getUITabMdslParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement436);
                    this_UITabMdsl_7=ruleUITabMdsl();

                    state._fsp--;

                     
                            current = this_UITabMdsl_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:219:5: this_CommandDeclaration_8= ruleCommandDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getCommandDeclarationParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement463);
                    this_CommandDeclaration_8=ruleCommandDeclaration();

                    state._fsp--;

                     
                            current = this_CommandDeclaration_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:229:5: this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTypeConfigurationMdslParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement490);
                    this_TypeConfigurationMdsl_9=ruleTypeConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_TypeConfigurationMdsl_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:239:5: this_TextMacro_10= ruleTextMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTextMacroParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleTextMacro_in_ruleMADConfigElement517);
                    this_TextMacro_10=ruleTextMacro();

                    state._fsp--;

                     
                            current = this_TextMacro_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:249:5: this_I18NBundleMdsl_11= ruleI18NBundleMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getI18NBundleMdslParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement544);
                    this_I18NBundleMdsl_11=ruleI18NBundleMdsl();

                    state._fsp--;

                     
                            current = this_I18NBundleMdsl_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:259:5: this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getIconDescriptorMdslParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement571);
                    this_IconDescriptorMdsl_12=ruleIconDescriptorMdsl();

                    state._fsp--;

                     
                            current = this_IconDescriptorMdsl_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMADConfigElement"


    // $ANTLR start "entryRuleImport"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:275:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:276:2: (iv_ruleImport= ruleImport EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:277:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport606);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport616); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:284:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:287:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport653); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:292:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:293:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:293:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:294:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport670); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleClassDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:318:1: entryRuleClassDescriptorMdsl returns [EObject current=null] : iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF ;
    public final EObject entryRuleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:319:2: (iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:320:2: iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getClassDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl711);
            iv_ruleClassDescriptorMdsl=ruleClassDescriptorMdsl();

            state._fsp--;

             current =iv_ruleClassDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassDescriptorMdsl721); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassDescriptorMdsl"


    // $ANTLR start "ruleClassDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:327:1: ruleClassDescriptorMdsl returns [EObject current=null] : ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_ClassName_0_0=null;
        Token otherlv_1=null;
        Token lv_pluginId_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:330:28: ( ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:2: ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:2: ( (lv_ClassName_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:332:1: (lv_ClassName_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:332:1: (lv_ClassName_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:333:3: lv_ClassName_0_0= RULE_ID
            {
            lv_ClassName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl763); 

            			newLeafNode(lv_ClassName_0_0, grammarAccess.getClassDescriptorMdslAccess().getClassNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ClassName",
                    		lv_ClassName_0_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:349:2: (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:349:4: otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleClassDescriptorMdsl781); 

                        	newLeafNode(otherlv_1, grammarAccess.getClassDescriptorMdslAccess().getFromPluginKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:353:1: ( (lv_pluginId_2_0= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:354:1: (lv_pluginId_2_0= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:354:1: (lv_pluginId_2_0= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:355:3: lv_pluginId_2_0= RULE_ID
                    {
                    lv_pluginId_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl798); 

                    			newLeafNode(lv_pluginId_2_0, grammarAccess.getClassDescriptorMdslAccess().getPluginIdIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"pluginId",
                            		lv_pluginId_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassDescriptorMdsl"


    // $ANTLR start "entryRulePropertyTypeMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:379:1: entryRulePropertyTypeMdsl returns [EObject current=null] : iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF ;
    public final EObject entryRulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyTypeMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:380:2: (iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:381:2: iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyTypeMdslRule()); 
            pushFollow(FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl841);
            iv_rulePropertyTypeMdsl=rulePropertyTypeMdsl();

            state._fsp--;

             current =iv_rulePropertyTypeMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyTypeMdsl851); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyTypeMdsl"


    // $ANTLR start "rulePropertyTypeMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:388:1: rulePropertyTypeMdsl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_label_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:391:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:393:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:393:1: (lv_name_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:394:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyTypeMdsl893); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPropertyTypeMdslAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyTypeMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_rulePropertyTypeMdsl910); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyTypeMdslAccess().getLabelKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:414:1: ( (lv_label_2_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:415:1: (lv_label_2_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:415:1: (lv_label_2_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:416:3: lv_label_2_0= RULE_STRING
            {
            lv_label_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl927); 

            			newLeafNode(lv_label_2_0, grammarAccess.getPropertyTypeMdslAccess().getLabelSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyTypeMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyTypeMdsl"


    // $ANTLR start "entryRulePropertyMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:440:1: entryRulePropertyMdsl returns [EObject current=null] : iv_rulePropertyMdsl= rulePropertyMdsl EOF ;
    public final EObject entryRulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:441:2: (iv_rulePropertyMdsl= rulePropertyMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:442:2: iv_rulePropertyMdsl= rulePropertyMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyMdslRule()); 
            pushFollow(FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl968);
            iv_rulePropertyMdsl=rulePropertyMdsl();

            state._fsp--;

             current =iv_rulePropertyMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyMdsl978); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyMdsl"


    // $ANTLR start "rulePropertyMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:449:1: rulePropertyMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) ;
    public final EObject rulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_propertyValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:452:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:454:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:454:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:455:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyMdsl1023); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyMdslAccess().getPropertyNamePropertyTypeMdslCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_rulePropertyMdsl1035); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyMdslAccess().getEqualsSignKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:470:1: ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:471:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:471:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:472:3: lv_propertyValue_2_0= rulePropertyValueMdsl
            {
             
            	        newCompositeNode(grammarAccess.getPropertyMdslAccess().getPropertyValuePropertyValueMdslParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1056);
            lv_propertyValue_2_0=rulePropertyValueMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyMdslRule());
            	        }
                   		set(
                   			current, 
                   			"propertyValue",
                    		lv_propertyValue_2_0, 
                    		"PropertyValueMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyMdsl"


    // $ANTLR start "entryRulePropertyValueMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:496:1: entryRulePropertyValueMdsl returns [EObject current=null] : iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF ;
    public final EObject entryRulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:497:2: (iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:498:2: iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueMdslRule()); 
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1092);
            iv_rulePropertyValueMdsl=rulePropertyValueMdsl();

            state._fsp--;

             current =iv_rulePropertyValueMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValueMdsl1102); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValueMdsl"


    // $ANTLR start "rulePropertyValueMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:505:1: rulePropertyValueMdsl returns [EObject current=null] : ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) ;
    public final EObject rulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:508:28: ( ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:510:1: (lv_fragments_0_0= rulePropValueExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:510:1: (lv_fragments_0_0= rulePropValueExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:511:3: lv_fragments_0_0= rulePropValueExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1148);
            lv_fragments_0_0=rulePropValueExprFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyValueMdslRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"PropValueExprFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:527:2: (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:527:4: otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePropertyValueMdsl1161); 

            	        	newLeafNode(otherlv_1, grammarAccess.getPropertyValueMdslAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:531:1: ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:532:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:532:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:533:3: lv_fragments_2_0= rulePropValueExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1182);
            	    lv_fragments_2_0=rulePropValueExprFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPropertyValueMdslRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"PropValueExprFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValueMdsl"


    // $ANTLR start "entryRulePropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:557:1: entryRulePropValueExprFragment returns [EObject current=null] : iv_rulePropValueExprFragment= rulePropValueExprFragment EOF ;
    public final EObject entryRulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:558:2: (iv_rulePropValueExprFragment= rulePropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:559:2: iv_rulePropValueExprFragment= rulePropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1220);
            iv_rulePropValueExprFragment=rulePropValueExprFragment();

            state._fsp--;

             current =iv_rulePropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropValueExprFragment1230); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropValueExprFragment"


    // $ANTLR start "rulePropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:566:1: rulePropValueExprFragment returns [EObject current=null] : (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject rulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteraPropValueExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:569:28: ( (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:570:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:570:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==105) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:571:5: this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getLiteraPropValueExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1277);
                    this_LiteraPropValueExprFragment_0=ruleLiteraPropValueExprFragment();

                    state._fsp--;

                     
                            current = this_LiteraPropValueExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:581:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1304);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropValueExprFragment"


    // $ANTLR start "entryRuleLiteraPropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:597:1: entryRuleLiteraPropValueExprFragment returns [EObject current=null] : iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF ;
    public final EObject entryRuleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteraPropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:598:2: (iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:599:2: iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteraPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1339);
            iv_ruleLiteraPropValueExprFragment=ruleLiteraPropValueExprFragment();

            state._fsp--;

             current =iv_ruleLiteraPropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteraPropValueExprFragment"


    // $ANTLR start "ruleLiteraPropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:606:1: ruleLiteraPropValueExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:609:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:610:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:610:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:611:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:611:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:612:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1390); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteraPropValueExprFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteraPropValueExprFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteraPropValueExprFragment"


    // $ANTLR start "entryRuleIconDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:636:1: entryRuleIconDescriptorMdsl returns [EObject current=null] : iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF ;
    public final EObject entryRuleIconDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIconDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:637:2: (iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:638:2: iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getIconDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1430);
            iv_ruleIconDescriptorMdsl=ruleIconDescriptorMdsl();

            state._fsp--;

             current =iv_ruleIconDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1440); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIconDescriptorMdsl"


    // $ANTLR start "ruleIconDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:645:1: ruleIconDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleIconDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_bundleUri_7_0=null;
        EObject lv_bundleDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:648:28: ( (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:3: otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIconDescriptorMdsl1477); 

                	newLeafNode(otherlv_0, grammarAccess.getIconDescriptorMdslAccess().getUseIconKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:653:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:654:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:654:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:655:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1494); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIconDescriptorMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:671:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:671:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleIconDescriptorMdsl1512); 

                        	newLeafNode(otherlv_2, grammarAccess.getIconDescriptorMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:675:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:676:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:676:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:677:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1529); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getIconDescriptorMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleIconDescriptorMdsl1550); 

                        	newLeafNode(otherlv_4, grammarAccess.getIconDescriptorMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:697:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:698:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:698:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:699:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getIconDescriptorMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1571);
                    lv_bundleDescriptor_5_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"bundleDescriptor",
                            		lv_bundleDescriptor_5_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleIconDescriptorMdsl1591); 

                        	newLeafNode(otherlv_6, grammarAccess.getIconDescriptorMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:720:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:721:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:721:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:722:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1608); 

                    			newLeafNode(lv_bundleUri_7_0, grammarAccess.getIconDescriptorMdslAccess().getBundleUriSTRINGTerminalRuleCall_3_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"bundleUri",
                            		lv_bundleUri_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIconDescriptorMdsl"


    // $ANTLR start "entryRuleI18NBundleMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:746:1: entryRuleI18NBundleMdsl returns [EObject current=null] : iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF ;
    public final EObject entryRuleI18NBundleMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleI18NBundleMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:747:2: (iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:748:2: iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF
            {
             newCompositeNode(grammarAccess.getI18NBundleMdslRule()); 
            pushFollow(FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1651);
            iv_ruleI18NBundleMdsl=ruleI18NBundleMdsl();

            state._fsp--;

             current =iv_ruleI18NBundleMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleI18NBundleMdsl1661); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleI18NBundleMdsl"


    // $ANTLR start "ruleI18NBundleMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:755:1: ruleI18NBundleMdsl returns [EObject current=null] : (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleI18NBundleMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_bundleUri_7_0=null;
        EObject lv_bundleDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:758:28: ( (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:3: otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleI18NBundleMdsl1698); 

                	newLeafNode(otherlv_0, grammarAccess.getI18NBundleMdslAccess().getUseI18NBundleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:763:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:764:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:764:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:765:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1715); 

            			newLeafNode(lv_name_1_0, grammarAccess.getI18NBundleMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:781:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:781:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleI18NBundleMdsl1733); 

                        	newLeafNode(otherlv_2, grammarAccess.getI18NBundleMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:785:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:786:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:786:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:787:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1750); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getI18NBundleMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleI18NBundleMdsl1771); 

                        	newLeafNode(otherlv_4, grammarAccess.getI18NBundleMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:807:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:808:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:808:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:809:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getI18NBundleMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1792);
                    lv_bundleDescriptor_5_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"bundleDescriptor",
                            		lv_bundleDescriptor_5_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleI18NBundleMdsl1812); 

                        	newLeafNode(otherlv_6, grammarAccess.getI18NBundleMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:830:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:831:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:831:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:832:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1829); 

                    			newLeafNode(lv_bundleUri_7_0, grammarAccess.getI18NBundleMdslAccess().getBundleUriSTRINGTerminalRuleCall_3_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"bundleUri",
                            		lv_bundleUri_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleI18NBundleMdsl"


    // $ANTLR start "entryRuleForeignModelMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:856:1: entryRuleForeignModelMdsl returns [EObject current=null] : iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF ;
    public final EObject entryRuleForeignModelMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeignModelMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:857:2: (iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:858:2: iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF
            {
             newCompositeNode(grammarAccess.getForeignModelMdslRule()); 
            pushFollow(FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1872);
            iv_ruleForeignModelMdsl=ruleForeignModelMdsl();

            state._fsp--;

             current =iv_ruleForeignModelMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForeignModelMdsl1882); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForeignModelMdsl"


    // $ANTLR start "ruleForeignModelMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:865:1: ruleForeignModelMdsl returns [EObject current=null] : (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' ) ;
    public final EObject ruleForeignModelMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_label_5_0=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_provider_8_0 = null;

        EObject lv_synchronizerFactoryClass_11_0 = null;

        EObject lv_extensionManagerClass_14_0 = null;

        EObject lv_dslReference_15_0 = null;

        EObject lv_relocatorQuery_17_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:868:28: ( (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:3: otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleForeignModelMdsl1919); 

                	newLeafNode(otherlv_0, grammarAccess.getForeignModelMdslAccess().getForeignModelKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleForeignModelMdsl1931); 

                	newLeafNode(otherlv_1, grammarAccess.getForeignModelMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleForeignModelMdsl1943); 

                	newLeafNode(otherlv_2, grammarAccess.getForeignModelMdslAccess().getModelTypeKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:881:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:882:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:882:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:883:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForeignModelMdsl1960); 

            			newLeafNode(lv_name_3_0, grammarAccess.getForeignModelMdslAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleForeignModelMdsl1977); 

                	newLeafNode(otherlv_4, grammarAccess.getForeignModelMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:903:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:904:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:904:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:905:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1994); 

            			newLeafNode(lv_label_5_0, grammarAccess.getForeignModelMdslAccess().getLabelSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:921:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:921:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleForeignModelMdsl2012); 

                        	newLeafNode(otherlv_6, grammarAccess.getForeignModelMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:925:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:926:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:926:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:927:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2029); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getForeignModelMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:943:4: ( (lv_provider_8_0= ruleModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:944:1: (lv_provider_8_0= ruleModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:944:1: (lv_provider_8_0= ruleModelProviderMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:945:3: lv_provider_8_0= ruleModelProviderMdsl
            {
             
            	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getProviderModelProviderMdslParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2057);
            lv_provider_8_0=ruleModelProviderMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
            	        }
                   		set(
                   			current, 
                   			"provider",
                    		lv_provider_8_0, 
                    		"ModelProviderMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:961:2: (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:961:4: otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleForeignModelMdsl2070); 

                        	newLeafNode(otherlv_9, grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryKeyword_8_0());
                        
                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleForeignModelMdsl2082); 

                        	newLeafNode(otherlv_10, grammarAccess.getForeignModelMdslAccess().getColonKeyword_8_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:969:1: ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:970:1: (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:970:1: (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:971:3: lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryClassClassDescriptorMdslParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2103);
                    lv_synchronizerFactoryClass_11_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"synchronizerFactoryClass",
                            		lv_synchronizerFactoryClass_11_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:987:4: (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:987:6: otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleForeignModelMdsl2118); 

                        	newLeafNode(otherlv_12, grammarAccess.getForeignModelMdslAccess().getExtensionManagerKeyword_9_0());
                        
                    otherlv_13=(Token)match(input,25,FOLLOW_25_in_ruleForeignModelMdsl2130); 

                        	newLeafNode(otherlv_13, grammarAccess.getForeignModelMdslAccess().getColonKeyword_9_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:995:1: ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:996:1: (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:996:1: (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:997:3: lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getExtensionManagerClassClassDescriptorMdslParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2151);
                    lv_extensionManagerClass_14_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"extensionManagerClass",
                            		lv_extensionManagerClass_14_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1013:4: ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1014:1: (lv_dslReference_15_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1014:1: (lv_dslReference_15_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1015:3: lv_dslReference_15_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2174);
                    lv_dslReference_15_0=ruleXtextLanguageReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"dslReference",
                            		lv_dslReference_15_0, 
                            		"XtextLanguageReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1031:3: (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1031:5: otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) )
                    {
                    otherlv_16=(Token)match(input,27,FOLLOW_27_in_ruleForeignModelMdsl2188); 

                        	newLeafNode(otherlv_16, grammarAccess.getForeignModelMdslAccess().getModelLocatorKeyword_11_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1035:1: ( (lv_relocatorQuery_17_0= ruleQuery ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1036:1: (lv_relocatorQuery_17_0= ruleQuery )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1036:1: (lv_relocatorQuery_17_0= ruleQuery )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1037:3: lv_relocatorQuery_17_0= ruleQuery
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getRelocatorQueryQueryParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQuery_in_ruleForeignModelMdsl2209);
                    lv_relocatorQuery_17_0=ruleQuery();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"relocatorQuery",
                            		lv_relocatorQuery_17_0, 
                            		"Query");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,28,FOLLOW_28_in_ruleForeignModelMdsl2223); 

                	newLeafNode(otherlv_18, grammarAccess.getForeignModelMdslAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForeignModelMdsl"


    // $ANTLR start "entryRuleModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1065:1: entryRuleModelProviderMdsl returns [EObject current=null] : iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF ;
    public final EObject entryRuleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1066:2: (iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1067:2: iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2259);
            iv_ruleModelProviderMdsl=ruleModelProviderMdsl();

            state._fsp--;

             current =iv_ruleModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelProviderMdsl2269); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelProviderMdsl"


    // $ANTLR start "ruleModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1074:1: ruleModelProviderMdsl returns [EObject current=null] : (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) ;
    public final EObject ruleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_URIModelProviderMdsl_0 = null;

        EObject this_URIExtensionModelProviderMdsl_1 = null;

        EObject this_CustomModelProviderMdsl_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1077:28: ( (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1078:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1078:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt16=1;
                }
                break;
            case 29:
                {
                alt16=2;
                }
                break;
            case 31:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1079:5: this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIModelProviderMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2316);
                    this_URIModelProviderMdsl_0=ruleURIModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIModelProviderMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1089:5: this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIExtensionModelProviderMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2343);
                    this_URIExtensionModelProviderMdsl_1=ruleURIExtensionModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIExtensionModelProviderMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1099:5: this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getCustomModelProviderMdslParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2370);
                    this_CustomModelProviderMdsl_2=ruleCustomModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_CustomModelProviderMdsl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelProviderMdsl"


    // $ANTLR start "entryRuleURIExtensionModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1115:1: entryRuleURIExtensionModelProviderMdsl returns [EObject current=null] : iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF ;
    public final EObject entryRuleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIExtensionModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1116:2: (iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1117:2: iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIExtensionModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2405);
            iv_ruleURIExtensionModelProviderMdsl=ruleURIExtensionModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIExtensionModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2415); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIExtensionModelProviderMdsl"


    // $ANTLR start "ruleURIExtensionModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1124:1: ruleURIExtensionModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uriExtension_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1127:28: ( (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1128:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1128:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1128:3: otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleURIExtensionModelProviderMdsl2452); 

                	newLeafNode(otherlv_0, grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1132:1: ( (lv_uriExtension_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1133:1: (lv_uriExtension_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1133:1: (lv_uriExtension_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1134:3: lv_uriExtension_1_0= RULE_STRING
            {
            lv_uriExtension_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2469); 

            			newLeafNode(lv_uriExtension_1_0, grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getURIExtensionModelProviderMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"uriExtension",
                    		lv_uriExtension_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIExtensionModelProviderMdsl"


    // $ANTLR start "entryRuleURIModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1158:1: entryRuleURIModelProviderMdsl returns [EObject current=null] : iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF ;
    public final EObject entryRuleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1159:2: (iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1160:2: iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2510);
            iv_ruleURIModelProviderMdsl=ruleURIModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2520); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIModelProviderMdsl"


    // $ANTLR start "ruleURIModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1167:1: ruleURIModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_modelUri_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1170:28: ( (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1171:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1171:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1171:3: otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleURIModelProviderMdsl2557); 

                	newLeafNode(otherlv_0, grammarAccess.getURIModelProviderMdslAccess().getModelUriKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1175:1: ( (lv_modelUri_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1176:1: (lv_modelUri_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1176:1: (lv_modelUri_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1177:3: lv_modelUri_1_0= RULE_STRING
            {
            lv_modelUri_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2574); 

            			newLeafNode(lv_modelUri_1_0, grammarAccess.getURIModelProviderMdslAccess().getModelUriSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getURIModelProviderMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"modelUri",
                    		lv_modelUri_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIModelProviderMdsl"


    // $ANTLR start "entryRuleCustomModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1201:1: entryRuleCustomModelProviderMdsl returns [EObject current=null] : iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF ;
    public final EObject entryRuleCustomModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1202:2: (iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1203:2: iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getCustomModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2615);
            iv_ruleCustomModelProviderMdsl=ruleCustomModelProviderMdsl();

            state._fsp--;

             current =iv_ruleCustomModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2625); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomModelProviderMdsl"


    // $ANTLR start "ruleCustomModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1210:1: ruleCustomModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) ;
    public final EObject ruleCustomModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_parameters_3_0=null;
        Token otherlv_4=null;
        Token lv_parameters_5_0=null;
        EObject lv_classDescriptor_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1213:28: ( (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1214:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1214:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1214:3: otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleCustomModelProviderMdsl2662); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomModelProviderMdslAccess().getProviderClassKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1218:1: ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1219:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1219:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1220:3: lv_classDescriptor_1_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCustomModelProviderMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2683);
            lv_classDescriptor_1_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCustomModelProviderMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_1_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1236:2: (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1236:4: otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleCustomModelProviderMdsl2696); 

                        	newLeafNode(otherlv_2, grammarAccess.getCustomModelProviderMdslAccess().getParametersKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1240:1: ( (lv_parameters_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1241:1: (lv_parameters_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1241:1: (lv_parameters_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1242:3: lv_parameters_3_0= RULE_STRING
                    {
                    lv_parameters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2713); 

                    			newLeafNode(lv_parameters_3_0, grammarAccess.getCustomModelProviderMdslAccess().getParametersSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCustomModelProviderMdslRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"parameters",
                            		lv_parameters_3_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1258:2: (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==33) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1258:4: otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleCustomModelProviderMdsl2731); 

                                	newLeafNode(otherlv_4, grammarAccess.getCustomModelProviderMdslAccess().getCommaKeyword_2_2_0());
                                
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1262:1: ( (lv_parameters_5_0= RULE_STRING ) )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1263:1: (lv_parameters_5_0= RULE_STRING )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1263:1: (lv_parameters_5_0= RULE_STRING )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1264:3: lv_parameters_5_0= RULE_STRING
                            {
                            lv_parameters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2748); 

                            			newLeafNode(lv_parameters_5_0, grammarAccess.getCustomModelProviderMdslAccess().getParametersSTRINGTerminalRuleCall_2_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCustomModelProviderMdslRule());
                            	        }
                                   		addWithLastConsumed(
                                   			current, 
                                   			"parameters",
                                    		lv_parameters_5_0, 
                                    		"STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomModelProviderMdsl"


    // $ANTLR start "entryRuleXtextLanguageDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1288:1: entryRuleXtextLanguageDescriptorMdsl returns [EObject current=null] : iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF ;
    public final EObject entryRuleXtextLanguageDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1289:2: (iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1290:2: iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2793);
            iv_ruleXtextLanguageDescriptorMdsl=ruleXtextLanguageDescriptorMdsl();

            state._fsp--;

             current =iv_ruleXtextLanguageDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2803); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXtextLanguageDescriptorMdsl"


    // $ANTLR start "ruleXtextLanguageDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1297:1: ruleXtextLanguageDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) ;
    public final EObject ruleXtextLanguageDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_languageId_3_0=null;
        Token otherlv_4=null;
        Token lv_bundleId_5_0=null;
        Token otherlv_6=null;
        Token lv_activatorClassName_7_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1300:28: ( (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1301:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1301:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1301:3: otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleXtextLanguageDescriptorMdsl2840); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getXtextDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1305:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1306:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1306:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1307:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2857); 

            			newLeafNode(lv_name_1_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleXtextLanguageDescriptorMdsl2874); 

                	newLeafNode(otherlv_2, grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1327:1: ( (lv_languageId_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1328:1: (lv_languageId_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1328:1: (lv_languageId_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1329:3: lv_languageId_3_0= RULE_ID
            {
            lv_languageId_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2891); 

            			newLeafNode(lv_languageId_3_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"languageId",
                    		lv_languageId_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2908); 

                	newLeafNode(otherlv_4, grammarAccess.getXtextLanguageDescriptorMdslAccess().getFromBundleKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1349:1: ( (lv_bundleId_5_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1350:1: (lv_bundleId_5_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1350:1: (lv_bundleId_5_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1351:3: lv_bundleId_5_0= RULE_ID
            {
            lv_bundleId_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2925); 

            			newLeafNode(lv_bundleId_5_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getBundleIdIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"bundleId",
                    		lv_bundleId_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,37,FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2942); 

                	newLeafNode(otherlv_6, grammarAccess.getXtextLanguageDescriptorMdslAccess().getWithActivatorKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1371:1: ( (lv_activatorClassName_7_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1372:1: (lv_activatorClassName_7_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1372:1: (lv_activatorClassName_7_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1373:3: lv_activatorClassName_7_0= RULE_ID
            {
            lv_activatorClassName_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2959); 

            			newLeafNode(lv_activatorClassName_7_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getActivatorClassNameIDTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"activatorClassName",
                    		lv_activatorClassName_7_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXtextLanguageDescriptorMdsl"


    // $ANTLR start "entryRuleXtextLanguageReference"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1397:1: entryRuleXtextLanguageReference returns [EObject current=null] : iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF ;
    public final EObject entryRuleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageReference = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1398:2: (iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1399:2: iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageReferenceRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference3000);
            iv_ruleXtextLanguageReference=ruleXtextLanguageReference();

            state._fsp--;

             current =iv_ruleXtextLanguageReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageReference3010); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXtextLanguageReference"


    // $ANTLR start "ruleXtextLanguageReference"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1406:1: ruleXtextLanguageReference returns [EObject current=null] : (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1409:28: ( (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1410:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1410:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1410:3: otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleXtextLanguageReference3047); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageReferenceAccess().getDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1414:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1415:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1415:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1416:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageReference3067); 

            		newLeafNode(otherlv_1, grammarAccess.getXtextLanguageReferenceAccess().getXtextLanguageDescriptorXtextLanguageDescriptorMdslCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXtextLanguageReference"


    // $ANTLR start "entryRuleOCLCustomLibraryMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1435:1: entryRuleOCLCustomLibraryMdsl returns [EObject current=null] : iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF ;
    public final EObject entryRuleOCLCustomLibraryMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLCustomLibraryMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1436:2: (iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1437:2: iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF
            {
             newCompositeNode(grammarAccess.getOCLCustomLibraryMdslRule()); 
            pushFollow(FOLLOW_ruleOCLCustomLibraryMdsl_in_entryRuleOCLCustomLibraryMdsl3103);
            iv_ruleOCLCustomLibraryMdsl=ruleOCLCustomLibraryMdsl();

            state._fsp--;

             current =iv_ruleOCLCustomLibraryMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOCLCustomLibraryMdsl3113); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOCLCustomLibraryMdsl"


    // $ANTLR start "ruleOCLCustomLibraryMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1444:1: ruleOCLCustomLibraryMdsl returns [EObject current=null] : (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleOCLCustomLibraryMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_label_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_8=null;
        EObject lv_classDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1447:28: ( (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1448:1: (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1448:1: (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1448:3: otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleOCLCustomLibraryMdsl3150); 

                	newLeafNode(otherlv_0, grammarAccess.getOCLCustomLibraryMdslAccess().getCustomOCLLibraryKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOCLCustomLibraryMdsl3162); 

                	newLeafNode(otherlv_1, grammarAccess.getOCLCustomLibraryMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleOCLCustomLibraryMdsl3174); 

                	newLeafNode(otherlv_2, grammarAccess.getOCLCustomLibraryMdslAccess().getLabelKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1460:1: ( (lv_label_3_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1461:1: (lv_label_3_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1461:1: (lv_label_3_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1462:3: lv_label_3_0= RULE_STRING
            {
            lv_label_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3191); 

            			newLeafNode(lv_label_3_0, grammarAccess.getOCLCustomLibraryMdslAccess().getLabelSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOCLCustomLibraryMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleOCLCustomLibraryMdsl3208); 

                	newLeafNode(otherlv_4, grammarAccess.getOCLCustomLibraryMdslAccess().getClassKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1482:1: ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1483:1: (lv_classDescriptor_5_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1483:1: (lv_classDescriptor_5_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1484:3: lv_classDescriptor_5_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getOCLCustomLibraryMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleOCLCustomLibraryMdsl3229);
            lv_classDescriptor_5_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOCLCustomLibraryMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_5_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1500:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1500:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleOCLCustomLibraryMdsl3242); 

                        	newLeafNode(otherlv_6, grammarAccess.getOCLCustomLibraryMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1504:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1505:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1505:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1506:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3259); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getOCLCustomLibraryMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOCLCustomLibraryMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleOCLCustomLibraryMdsl3278); 

                	newLeafNode(otherlv_8, grammarAccess.getOCLCustomLibraryMdslAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOCLCustomLibraryMdsl"


    // $ANTLR start "entryRuleQueryEvaluatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1534:1: entryRuleQueryEvaluatorMdsl returns [EObject current=null] : iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF ;
    public final EObject entryRuleQueryEvaluatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryEvaluatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1535:2: (iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1536:2: iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryEvaluatorMdslRule()); 
            pushFollow(FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3314);
            iv_ruleQueryEvaluatorMdsl=ruleQueryEvaluatorMdsl();

            state._fsp--;

             current =iv_ruleQueryEvaluatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3324); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryEvaluatorMdsl"


    // $ANTLR start "ruleQueryEvaluatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1543:1: ruleQueryEvaluatorMdsl returns [EObject current=null] : (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) ;
    public final EObject ruleQueryEvaluatorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_label_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_description_16_0=null;
        Token otherlv_17=null;
        EObject lv_classDescriptor_8_0 = null;

        EObject lv_queryPropertiesTypes_10_0 = null;

        EObject lv_queryPropertiesTypes_12_0 = null;

        EObject lv_extQServiceClassDescriptor_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1546:28: ( (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1547:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1547:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1547:3: otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleQueryEvaluatorMdsl3361); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryEvaluatorMdslAccess().getQueryEvaluatorKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryEvaluatorMdsl3373); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryEvaluatorMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleQueryEvaluatorMdsl3385); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryEvaluatorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1559:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1560:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1560:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1561:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3402); 

            			newLeafNode(lv_name_3_0, grammarAccess.getQueryEvaluatorMdslAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleQueryEvaluatorMdsl3419); 

                	newLeafNode(otherlv_4, grammarAccess.getQueryEvaluatorMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1581:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1582:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1582:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1583:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3436); 

            			newLeafNode(lv_label_5_0, grammarAccess.getQueryEvaluatorMdslAccess().getLabelSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,43,FOLLOW_43_in_ruleQueryEvaluatorMdsl3453); 

                	newLeafNode(otherlv_6, grammarAccess.getQueryEvaluatorMdslAccess().getEvaluatorKeyword_6());
                
            otherlv_7=(Token)match(input,40,FOLLOW_40_in_ruleQueryEvaluatorMdsl3465); 

                	newLeafNode(otherlv_7, grammarAccess.getQueryEvaluatorMdslAccess().getClassKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1607:1: ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1608:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1608:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1609:3: lv_classDescriptor_8_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3486);
            lv_classDescriptor_8_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_8_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1625:2: (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==44) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1625:4: otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    {
                    otherlv_9=(Token)match(input,44,FOLLOW_44_in_ruleQueryEvaluatorMdsl3499); 

                        	newLeafNode(otherlv_9, grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypeKeyword_9_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1629:1: ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1630:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1630:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1631:3: lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3520);
                    lv_queryPropertiesTypes_10_0=rulePropertyTypeMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"queryPropertiesTypes",
                            		lv_queryPropertiesTypes_10_0, 
                            		"PropertyTypeMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1647:2: (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==33) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1647:4: otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    {
                    	    otherlv_11=(Token)match(input,33,FOLLOW_33_in_ruleQueryEvaluatorMdsl3533); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getQueryEvaluatorMdslAccess().getCommaKeyword_9_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1651:1: ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1652:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1652:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1653:3: lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3554);
                    	    lv_queryPropertiesTypes_12_0=rulePropertyTypeMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"queryPropertiesTypes",
                    	            		lv_queryPropertiesTypes_12_0, 
                    	            		"PropertyTypeMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1669:6: (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==45) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1669:8: otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_13=(Token)match(input,45,FOLLOW_45_in_ruleQueryEvaluatorMdsl3571); 

                        	newLeafNode(otherlv_13, grammarAccess.getQueryEvaluatorMdslAccess().getExternalQueryProviderKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1673:1: ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1674:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1674:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1675:3: lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getExtQServiceClassDescriptorClassDescriptorMdslParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3592);
                    lv_extQServiceClassDescriptor_14_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"extQServiceClassDescriptor",
                            		lv_extQServiceClassDescriptor_14_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1691:4: (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1691:6: otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleQueryEvaluatorMdsl3607); 

                        	newLeafNode(otherlv_15, grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionKeyword_11_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1695:1: ( (lv_description_16_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1696:1: (lv_description_16_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1696:1: (lv_description_16_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1697:3: lv_description_16_0= RULE_STRING
                    {
                    lv_description_16_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3624); 

                    			newLeafNode(lv_description_16_0, grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionSTRINGTerminalRuleCall_11_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_16_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,28,FOLLOW_28_in_ruleQueryEvaluatorMdsl3643); 

                	newLeafNode(otherlv_17, grammarAccess.getQueryEvaluatorMdslAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryEvaluatorMdsl"


    // $ANTLR start "entryRuleWidgetType"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1725:1: entryRuleWidgetType returns [EObject current=null] : iv_ruleWidgetType= ruleWidgetType EOF ;
    public final EObject entryRuleWidgetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetType = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1726:2: (iv_ruleWidgetType= ruleWidgetType EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1727:2: iv_ruleWidgetType= ruleWidgetType EOF
            {
             newCompositeNode(grammarAccess.getWidgetTypeRule()); 
            pushFollow(FOLLOW_ruleWidgetType_in_entryRuleWidgetType3679);
            iv_ruleWidgetType=ruleWidgetType();

            state._fsp--;

             current =iv_ruleWidgetType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetType3689); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWidgetType"


    // $ANTLR start "ruleWidgetType"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1734:1: ruleWidgetType returns [EObject current=null] : (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleWidgetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_label_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Enumerator lv_category_5_0 = null;

        EObject lv_classDescriptor_9_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1737:28: ( (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1738:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1738:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1738:3: otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleWidgetType3726); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetTypeAccess().getWidgetTypeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleWidgetType3738); 

                	newLeafNode(otherlv_1, grammarAccess.getWidgetTypeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleWidgetType3750); 

                	newLeafNode(otherlv_2, grammarAccess.getWidgetTypeAccess().getNameKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1750:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1751:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1751:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1752:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetType3767); 

            			newLeafNode(lv_name_3_0, grammarAccess.getWidgetTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleWidgetType3784); 

                	newLeafNode(otherlv_4, grammarAccess.getWidgetTypeAccess().getCategoryKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1772:1: ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1773:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1773:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1774:3: lv_category_5_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3805);
            lv_category_5_0=ruleWIDGET_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetTypeRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_5_0, 
                    		"WIDGET_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleWidgetType3817); 

                	newLeafNode(otherlv_6, grammarAccess.getWidgetTypeAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1794:1: ( (lv_label_7_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1795:1: (lv_label_7_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1795:1: (lv_label_7_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1796:3: lv_label_7_0= RULE_STRING
            {
            lv_label_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3834); 

            			newLeafNode(lv_label_7_0, grammarAccess.getWidgetTypeAccess().getLabelSTRINGTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_7_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_8=(Token)match(input,49,FOLLOW_49_in_ruleWidgetType3851); 

                	newLeafNode(otherlv_8, grammarAccess.getWidgetTypeAccess().getCustomWidgetKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1816:1: ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1817:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1817:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1818:3: lv_classDescriptor_9_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3872);
            lv_classDescriptor_9_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetTypeRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_9_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1834:2: (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==17) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1834:4: otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleWidgetType3885); 

                        	newLeafNode(otherlv_10, grammarAccess.getWidgetTypeAccess().getDescriptionKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1838:1: ( (lv_description_11_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1839:1: (lv_description_11_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1839:1: (lv_description_11_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1840:3: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3902); 

                    			newLeafNode(lv_description_11_0, grammarAccess.getWidgetTypeAccess().getDescriptionSTRINGTerminalRuleCall_10_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_11_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleWidgetType3921); 

                	newLeafNode(otherlv_12, grammarAccess.getWidgetTypeAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWidgetType"


    // $ANTLR start "entryRuleUITabMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1868:1: entryRuleUITabMdsl returns [EObject current=null] : iv_ruleUITabMdsl= ruleUITabMdsl EOF ;
    public final EObject entryRuleUITabMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUITabMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1869:2: (iv_ruleUITabMdsl= ruleUITabMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1870:2: iv_ruleUITabMdsl= ruleUITabMdsl EOF
            {
             newCompositeNode(grammarAccess.getUITabMdslRule()); 
            pushFollow(FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl3957);
            iv_ruleUITabMdsl=ruleUITabMdsl();

            state._fsp--;

             current =iv_ruleUITabMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUITabMdsl3967); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUITabMdsl"


    // $ANTLR start "ruleUITabMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1877:1: ruleUITabMdsl returns [EObject current=null] : (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleUITabMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_i18NLabel_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_description_9_0=null;
        Token otherlv_10=null;
        EObject lv_labelFormatExpr_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1880:28: ( (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1881:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1881:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1881:3: otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleUITabMdsl4004); 

                	newLeafNode(otherlv_0, grammarAccess.getUITabMdslAccess().getUIKeyword_0());
                
            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleUITabMdsl4016); 

                	newLeafNode(otherlv_1, grammarAccess.getUITabMdslAccess().getTabKeyword_1());
                
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleUITabMdsl4028); 

                	newLeafNode(otherlv_2, grammarAccess.getUITabMdslAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleUITabMdsl4040); 

                	newLeafNode(otherlv_3, grammarAccess.getUITabMdslAccess().getIdKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1897:1: ( (lv_name_4_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1898:1: (lv_name_4_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1898:1: (lv_name_4_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1899:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUITabMdsl4057); 

            			newLeafNode(lv_name_4_0, grammarAccess.getUITabMdslAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUITabMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1915:2: ( (lv_i18NLabel_5_0= 'I18N' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==53) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1916:1: (lv_i18NLabel_5_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1916:1: (lv_i18NLabel_5_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1917:3: lv_i18NLabel_5_0= 'I18N'
                    {
                    lv_i18NLabel_5_0=(Token)match(input,53,FOLLOW_53_in_ruleUITabMdsl4080); 

                            newLeafNode(lv_i18NLabel_5_0, grammarAccess.getUITabMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUITabMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleUITabMdsl4106); 

                	newLeafNode(otherlv_6, grammarAccess.getUITabMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1934:1: ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1935:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1935:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1936:3: lv_labelFormatExpr_7_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getUITabMdslAccess().getLabelFormatExprFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleUITabMdsl4127);
            lv_labelFormatExpr_7_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUITabMdslRule());
            	        }
                   		set(
                   			current, 
                   			"labelFormatExpr",
                    		lv_labelFormatExpr_7_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1952:2: (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==17) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1952:4: otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleUITabMdsl4140); 

                        	newLeafNode(otherlv_8, grammarAccess.getUITabMdslAccess().getDescriptionKeyword_8_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1956:1: ( (lv_description_9_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1957:1: (lv_description_9_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1957:1: (lv_description_9_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1958:3: lv_description_9_0= RULE_STRING
                    {
                    lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUITabMdsl4157); 

                    			newLeafNode(lv_description_9_0, grammarAccess.getUITabMdslAccess().getDescriptionSTRINGTerminalRuleCall_8_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUITabMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_9_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleUITabMdsl4176); 

                	newLeafNode(otherlv_10, grammarAccess.getUITabMdslAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUITabMdsl"


    // $ANTLR start "entryRuleLayerMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1986:1: entryRuleLayerMdsl returns [EObject current=null] : iv_ruleLayerMdsl= ruleLayerMdsl EOF ;
    public final EObject entryRuleLayerMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1987:2: (iv_ruleLayerMdsl= ruleLayerMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1988:2: iv_ruleLayerMdsl= ruleLayerMdsl EOF
            {
             newCompositeNode(grammarAccess.getLayerMdslRule()); 
            pushFollow(FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl4212);
            iv_ruleLayerMdsl=ruleLayerMdsl();

            state._fsp--;

             current =iv_ruleLayerMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerMdsl4222); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerMdsl"


    // $ANTLR start "ruleLayerMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1995:1: ruleLayerMdsl returns [EObject current=null] : (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
    public final EObject ruleLayerMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_i18NLabel_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_labelFormatExpr_5_0 = null;

        EObject lv_subLayers_11_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1998:28: ( (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1999:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1999:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1999:3: otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleLayerMdsl4259); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerMdslAccess().getLayerKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2003:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2004:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2004:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2005:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLayerMdsl4276); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLayerMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLayerMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4293); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2025:1: ( (lv_i18NLabel_3_0= 'I18N' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==53) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2026:1: (lv_i18NLabel_3_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2026:1: (lv_i18NLabel_3_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2027:3: lv_i18NLabel_3_0= 'I18N'
                    {
                    lv_i18NLabel_3_0=(Token)match(input,53,FOLLOW_53_in_ruleLayerMdsl4311); 

                            newLeafNode(lv_i18NLabel_3_0, grammarAccess.getLayerMdslAccess().getI18NLabelI18NKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayerMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleLayerMdsl4337); 

                	newLeafNode(otherlv_4, grammarAccess.getLayerMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2044:1: ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2045:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2045:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2046:3: lv_labelFormatExpr_5_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getLayerMdslAccess().getLabelFormatExprFormatExprParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4358);
            lv_labelFormatExpr_5_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerMdslRule());
            	        }
                   		set(
                   			current, 
                   			"labelFormatExpr",
                    		lv_labelFormatExpr_5_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2062:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==17) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2062:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleLayerMdsl4371); 

                        	newLeafNode(otherlv_6, grammarAccess.getLayerMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2066:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2067:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2067:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2068:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLayerMdsl4388); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getLayerMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayerMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2084:4: (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==55) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2084:6: otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}'
                    {
                    otherlv_8=(Token)match(input,55,FOLLOW_55_in_ruleLayerMdsl4408); 

                        	newLeafNode(otherlv_8, grammarAccess.getLayerMdslAccess().getSubKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,56,FOLLOW_56_in_ruleLayerMdsl4420); 

                        	newLeafNode(otherlv_9, grammarAccess.getLayerMdslAccess().getLayersKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4432); 

                        	newLeafNode(otherlv_10, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_7_2());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2096:1: ( (lv_subLayers_11_0= ruleLayerMdsl ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==54) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2097:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2097:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2098:3: lv_subLayers_11_0= ruleLayerMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLayerMdslAccess().getSubLayersLayerMdslParserRuleCall_7_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4453);
                    	    lv_subLayers_11_0=ruleLayerMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLayerMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"subLayers",
                    	            		lv_subLayers_11_0, 
                    	            		"LayerMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleLayerMdsl4466); 

                        	newLeafNode(otherlv_12, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,28,FOLLOW_28_in_ruleLayerMdsl4480); 

                	newLeafNode(otherlv_13, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerMdsl"


    // $ANTLR start "entryRuleTypeConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2130:1: entryRuleTypeConfigurationMdsl returns [EObject current=null] : iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF ;
    public final EObject entryRuleTypeConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2131:2: (iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2132:2: iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4516);
            iv_ruleTypeConfigurationMdsl=ruleTypeConfigurationMdsl();

            state._fsp--;

             current =iv_ruleTypeConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4526); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConfigurationMdsl"


    // $ANTLR start "ruleTypeConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2139:1: ruleTypeConfigurationMdsl returns [EObject current=null] : ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) ;
    public final EObject ruleTypeConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_defaultConfiguration_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_i18NLabelProvider_6_0=null;
        Token otherlv_7=null;
        Token lv_useExplicitExtends_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_layoutDefined_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_labelProviderExpression_8_0 = null;

        EObject lv_templateElements_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2142:28: ( ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2143:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2143:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2143:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2143:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==57) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2144:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2144:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2145:3: lv_defaultConfiguration_0_0= 'DEFAULT'
                    {
                    lv_defaultConfiguration_0_0=(Token)match(input,57,FOLLOW_57_in_ruleTypeConfigurationMdsl4569); 

                            newLeafNode(lv_defaultConfiguration_0_0, grammarAccess.getTypeConfigurationMdslAccess().getDefaultConfigurationDEFAULTKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "defaultConfiguration", true, "DEFAULT");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleTypeConfigurationMdsl4595); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeConfigurationMdslAccess().getConfigurationKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2163:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2163:1: (lv_name_2_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2164:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4612); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeConfigurationMdslAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2180:2: (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==59) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2180:4: otherlv_3= 'for' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleTypeConfigurationMdsl4630); 

                        	newLeafNode(otherlv_3, grammarAccess.getTypeConfigurationMdslAccess().getForKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2184:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2185:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2185:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2186:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4650); 

                    		newLeafNode(otherlv_4, grammarAccess.getTypeConfigurationMdslAccess().getTypeEClassCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleTypeConfigurationMdsl4664); 

                	newLeafNode(otherlv_5, grammarAccess.getTypeConfigurationMdslAccess().getLeftCurlyBracketKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2201:1: ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==53||LA34_0==60) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2201:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2201:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==53) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2202:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2202:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2203:3: lv_i18NLabelProvider_6_0= 'I18N'
                            {
                            lv_i18NLabelProvider_6_0=(Token)match(input,53,FOLLOW_53_in_ruleTypeConfigurationMdsl4683); 

                                    newLeafNode(lv_i18NLabelProvider_6_0, grammarAccess.getTypeConfigurationMdslAccess().getI18NLabelProviderI18NKeyword_5_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelProvider", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,60,FOLLOW_60_in_ruleTypeConfigurationMdsl4709); 

                        	newLeafNode(otherlv_7, grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderKeyword_5_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2220:1: ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2221:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2221:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2222:3: lv_labelProviderExpression_8_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderExpressionFormatExprParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4730);
                    lv_labelProviderExpression_8_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"labelProviderExpression",
                            		lv_labelProviderExpression_8_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2238:4: ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==61) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2238:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2238:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2239:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2239:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2240:3: lv_useExplicitExtends_9_0= 'extends:'
                    {
                    lv_useExplicitExtends_9_0=(Token)match(input,61,FOLLOW_61_in_ruleTypeConfigurationMdsl4751); 

                            newLeafNode(lv_useExplicitExtends_9_0, grammarAccess.getTypeConfigurationMdslAccess().getUseExplicitExtendsExtendsKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "useExplicitExtends", true, "extends:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2253:2: ( (otherlv_10= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2254:1: (otherlv_10= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2254:1: (otherlv_10= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2255:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4784); 

                    		newLeafNode(otherlv_10, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2266:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==33) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2266:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,33,FOLLOW_33_in_ruleTypeConfigurationMdsl4797); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getTypeConfigurationMdslAccess().getCommaKeyword_6_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2270:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2271:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2271:1: (otherlv_12= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2272:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4817); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,62,FOLLOW_62_in_ruleTypeConfigurationMdsl4833); 

                	newLeafNode(otherlv_13, grammarAccess.getTypeConfigurationMdslAccess().getTemplateKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2287:1: ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==64||LA37_0==68) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2288:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2288:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2289:3: lv_templateElements_14_0= ruleTypeConfigurationTemplateElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getTemplateElementsTypeConfigurationTemplateElementParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4854);
            	    lv_templateElements_14_0=ruleTypeConfigurationTemplateElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTypeConfigurationMdslRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"templateElements",
            	            		lv_templateElements_14_0, 
            	            		"TypeConfigurationTemplateElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2305:3: ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==63) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2305:4: ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2305:4: ( (lv_layoutDefined_15_0= 'layout:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2306:1: (lv_layoutDefined_15_0= 'layout:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2306:1: (lv_layoutDefined_15_0= 'layout:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2307:3: lv_layoutDefined_15_0= 'layout:'
                    {
                    lv_layoutDefined_15_0=(Token)match(input,63,FOLLOW_63_in_ruleTypeConfigurationMdsl4874); 

                            newLeafNode(lv_layoutDefined_15_0, grammarAccess.getTypeConfigurationMdslAccess().getLayoutDefinedLayoutKeyword_9_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "layoutDefined", true, "layout:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2320:2: ( (otherlv_16= RULE_ID ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2321:1: (otherlv_16= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2321:1: (otherlv_16= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2322:3: otherlv_16= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4907); 

                    	    		newLeafNode(otherlv_16, grammarAccess.getTypeConfigurationMdslAccess().getLayoutElementsWidgetConfigurationMdslCrossReference_9_1_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,28,FOLLOW_28_in_ruleTypeConfigurationMdsl4922); 

                	newLeafNode(otherlv_17, grammarAccess.getTypeConfigurationMdslAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConfigurationMdsl"


    // $ANTLR start "entryRuleTypeConfigurationTemplateElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2345:1: entryRuleTypeConfigurationTemplateElement returns [EObject current=null] : iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF ;
    public final EObject entryRuleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationTemplateElement = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2346:2: (iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2347:2: iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement4958);
            iv_ruleTypeConfigurationTemplateElement=ruleTypeConfigurationTemplateElement();

            state._fsp--;

             current =iv_ruleTypeConfigurationTemplateElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement4968); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConfigurationTemplateElement"


    // $ANTLR start "ruleTypeConfigurationTemplateElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2354:1: ruleTypeConfigurationTemplateElement returns [EObject current=null] : (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) ;
    public final EObject ruleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject this_WidgetConfigurationMdsl_0 = null;

        EObject this_IncludeTemplateElementMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2357:28: ( (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2358:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2358:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==68) ) {
                alt40=1;
            }
            else if ( (LA40_0==64) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2359:5: this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getWidgetConfigurationMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement5015);
                    this_WidgetConfigurationMdsl_0=ruleWidgetConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_WidgetConfigurationMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2369:5: this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getIncludeTemplateElementMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement5042);
                    this_IncludeTemplateElementMdsl_1=ruleIncludeTemplateElementMdsl();

                    state._fsp--;

                     
                            current = this_IncludeTemplateElementMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConfigurationTemplateElement"


    // $ANTLR start "entryRuleIncludeTemplateElementMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2385:1: entryRuleIncludeTemplateElementMdsl returns [EObject current=null] : iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF ;
    public final EObject entryRuleIncludeTemplateElementMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeTemplateElementMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2386:2: (iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2387:2: iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF
            {
             newCompositeNode(grammarAccess.getIncludeTemplateElementMdslRule()); 
            pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl5077);
            iv_ruleIncludeTemplateElementMdsl=ruleIncludeTemplateElementMdsl();

            state._fsp--;

             current =iv_ruleIncludeTemplateElementMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl5087); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeTemplateElementMdsl"


    // $ANTLR start "ruleIncludeTemplateElementMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2394:1: ruleIncludeTemplateElementMdsl returns [EObject current=null] : (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) ;
    public final EObject ruleIncludeTemplateElementMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_valueQuery_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2397:28: ( (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2398:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2398:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2398:3: otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleIncludeTemplateElementMdsl5124); 

                	newLeafNode(otherlv_0, grammarAccess.getIncludeTemplateElementMdslAccess().getIncludeWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2402:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2403:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2403:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2404:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5141); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIncludeTemplateElementMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,65,FOLLOW_65_in_ruleIncludeTemplateElementMdsl5158); 

                	newLeafNode(otherlv_2, grammarAccess.getIncludeTemplateElementMdslAccess().getSourceTemplateKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2424:1: ( (otherlv_3= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2425:1: (otherlv_3= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2425:1: (otherlv_3= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2426:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5178); 

            		newLeafNode(otherlv_3, grammarAccess.getIncludeTemplateElementMdslAccess().getRefIncludedTemplateTypeConfigurationMdslCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,66,FOLLOW_66_in_ruleIncludeTemplateElementMdsl5190); 

                	newLeafNode(otherlv_4, grammarAccess.getIncludeTemplateElementMdslAccess().getValueKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2441:1: ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2442:1: (lv_valueQuery_5_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2442:1: (lv_valueQuery_5_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2443:3: lv_valueQuery_5_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getIncludeTemplateElementMdslAccess().getValueQueryQueryUsageParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl5211);
            lv_valueQuery_5_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                   		set(
                   			current, 
                   			"valueQuery",
                    		lv_valueQuery_5_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeTemplateElementMdsl"


    // $ANTLR start "entryRuleValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2467:1: entryRuleValueConverter returns [EObject current=null] : iv_ruleValueConverter= ruleValueConverter EOF ;
    public final EObject entryRuleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2468:2: (iv_ruleValueConverter= ruleValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2469:2: iv_ruleValueConverter= ruleValueConverter EOF
            {
             newCompositeNode(grammarAccess.getValueConverterRule()); 
            pushFollow(FOLLOW_ruleValueConverter_in_entryRuleValueConverter5247);
            iv_ruleValueConverter=ruleValueConverter();

            state._fsp--;

             current =iv_ruleValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueConverter5257); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueConverter"


    // $ANTLR start "ruleValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2476:1: ruleValueConverter returns [EObject current=null] : (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) ;
    public final EObject ruleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject this_BasicTypeValueConverter_0 = null;

        EObject this_QueryBasedValueConverter_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2479:28: ( (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2480:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2480:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=106 && LA41_0<=111)) ) {
                alt41=1;
            }
            else if ( (LA41_0==67) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2481:5: this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getBasicTypeValueConverterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5304);
                    this_BasicTypeValueConverter_0=ruleBasicTypeValueConverter();

                    state._fsp--;

                     
                            current = this_BasicTypeValueConverter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2491:5: this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getQueryBasedValueConverterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5331);
                    this_QueryBasedValueConverter_1=ruleQueryBasedValueConverter();

                    state._fsp--;

                     
                            current = this_QueryBasedValueConverter_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueConverter"


    // $ANTLR start "entryRuleQueryBasedValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2507:1: entryRuleQueryBasedValueConverter returns [EObject current=null] : iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF ;
    public final EObject entryRuleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBasedValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2508:2: (iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2509:2: iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF
            {
             newCompositeNode(grammarAccess.getQueryBasedValueConverterRule()); 
            pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5366);
            iv_ruleQueryBasedValueConverter=ruleQueryBasedValueConverter();

            state._fsp--;

             current =iv_ruleQueryBasedValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5376); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryBasedValueConverter"


    // $ANTLR start "ruleQueryBasedValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2516:1: ruleQueryBasedValueConverter returns [EObject current=null] : (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) ;
    public final EObject ruleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_converterQuery_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2519:28: ( (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2520:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2520:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2520:3: otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleQueryBasedValueConverter5413); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryBasedValueConverterAccess().getQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2524:1: ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2525:1: (lv_converterQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2525:1: (lv_converterQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2526:3: lv_converterQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getQueryBasedValueConverterAccess().getConverterQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5434);
            lv_converterQuery_1_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryBasedValueConverterRule());
            	        }
                   		set(
                   			current, 
                   			"converterQuery",
                    		lv_converterQuery_1_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryBasedValueConverter"


    // $ANTLR start "entryRuleBasicTypeValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2550:1: entryRuleBasicTypeValueConverter returns [EObject current=null] : iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF ;
    public final EObject entryRuleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicTypeValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2551:2: (iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2552:2: iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeValueConverterRule()); 
            pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5470);
            iv_ruleBasicTypeValueConverter=ruleBasicTypeValueConverter();

            state._fsp--;

             current =iv_ruleBasicTypeValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5480); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicTypeValueConverter"


    // $ANTLR start "ruleBasicTypeValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2559:1: ruleBasicTypeValueConverter returns [EObject current=null] : ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_configuration_2_0=null;
        Enumerator lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2562:28: ( ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2563:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2563:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2563:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2563:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2564:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2564:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2565:3: lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getBasicTypeValueConverterAccess().getCategoryVALUE_CONVERTER_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5526);
            lv_category_0_0=ruleVALUE_CONVERTER_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBasicTypeValueConverterRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"VALUE_CONVERTER_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2581:2: (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==25) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2581:4: otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleBasicTypeValueConverter5539); 

                        	newLeafNode(otherlv_1, grammarAccess.getBasicTypeValueConverterAccess().getColonKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2585:1: ( (lv_configuration_2_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2586:1: (lv_configuration_2_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2586:1: (lv_configuration_2_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2587:3: lv_configuration_2_0= RULE_STRING
                    {
                    lv_configuration_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5556); 

                    			newLeafNode(lv_configuration_2_0, grammarAccess.getBasicTypeValueConverterAccess().getConfigurationSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBasicTypeValueConverterRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"configuration",
                            		lv_configuration_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicTypeValueConverter"


    // $ANTLR start "entryRuleWidgetConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2611:1: entryRuleWidgetConfigurationMdsl returns [EObject current=null] : iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF ;
    public final EObject entryRuleWidgetConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2612:2: (iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2613:2: iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getWidgetConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5599);
            iv_ruleWidgetConfigurationMdsl=ruleWidgetConfigurationMdsl();

            state._fsp--;

             current =iv_ruleWidgetConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5609); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWidgetConfigurationMdsl"


    // $ANTLR start "ruleWidgetConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2620:1: ruleWidgetConfigurationMdsl returns [EObject current=null] : (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) ;
    public final EObject ruleWidgetConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_i18NLabel_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token lv_i18NFormat_32_0=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token lv_i18NItemLabel_37_0=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        EObject lv_label_12_0 = null;

        Enumerator lv_widgetCategory_14_0 = null;

        EObject lv_dslReference_17_0 = null;

        EObject lv_visibilityQuery_23_0 = null;

        EObject lv_editableQuery_25_0 = null;

        EObject lv_valueQuery_27_0 = null;

        EObject lv_valueConverter_29_0 = null;

        EObject lv_validators_31_0 = null;

        EObject lv_valueFormat_34_0 = null;

        EObject lv_candidatesQuery_36_0 = null;

        EObject lv_itemLabelExpression_39_0 = null;

        EObject lv_commands_41_0 = null;

        EObject lv_commands_43_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2623:28: ( (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2624:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2624:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2624:3: otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            {
            otherlv_0=(Token)match(input,68,FOLLOW_68_in_ruleWidgetConfigurationMdsl5646); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2628:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2629:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2629:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2630:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5663); 

            			newLeafNode(lv_name_1_0, grammarAccess.getWidgetConfigurationMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2646:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==17) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2646:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleWidgetConfigurationMdsl5681); 

                        	newLeafNode(otherlv_2, grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2650:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2651:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2651:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2652:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5698); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2668:4: (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==69) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2668:6: otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,69,FOLLOW_69_in_ruleWidgetConfigurationMdsl5718); 

                        	newLeafNode(otherlv_4, grammarAccess.getWidgetConfigurationMdslAccess().getTabKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2672:1: ( (otherlv_5= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2673:1: (otherlv_5= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2673:1: (otherlv_5= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2674:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5738); 

                    		newLeafNode(otherlv_5, grammarAccess.getWidgetConfigurationMdslAccess().getUiTabUITabMdslCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2685:4: (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==70) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2685:6: otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,70,FOLLOW_70_in_ruleWidgetConfigurationMdsl5753); 

                        	newLeafNode(otherlv_6, grammarAccess.getWidgetConfigurationMdslAccess().getLayersKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2689:1: ( (otherlv_7= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2690:1: (otherlv_7= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2690:1: (otherlv_7= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2691:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5773); 

                    		newLeafNode(otherlv_7, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2702:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==33) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2702:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleWidgetConfigurationMdsl5786); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2706:1: ( (otherlv_9= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2707:1: (otherlv_9= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2707:1: (otherlv_9= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2708:3: otherlv_9= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5806); 

                    	    		newLeafNode(otherlv_9, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2719:6: ( (lv_i18NLabel_10_0= 'I18N' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2720:1: (lv_i18NLabel_10_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2720:1: (lv_i18NLabel_10_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2721:3: lv_i18NLabel_10_0= 'I18N'
                    {
                    lv_i18NLabel_10_0=(Token)match(input,53,FOLLOW_53_in_ruleWidgetConfigurationMdsl5828); 

                            newLeafNode(lv_i18NLabel_10_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleWidgetConfigurationMdsl5854); 

                	newLeafNode(otherlv_11, grammarAccess.getWidgetConfigurationMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2738:1: ( (lv_label_12_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2739:1: (lv_label_12_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2739:1: (lv_label_12_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:3: lv_label_12_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getLabelFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5875);
            lv_label_12_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		set(
                   			current, 
                   			"label",
                    		lv_label_12_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_13=(Token)match(input,71,FOLLOW_71_in_ruleWidgetConfigurationMdsl5887); 

                	newLeafNode(otherlv_13, grammarAccess.getWidgetConfigurationMdslAccess().getTypeKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2760:1: ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2761:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2761:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2762:3: lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getWidgetCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5908);
            lv_widgetCategory_14_0=ruleWIDGET_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		set(
                   			current, 
                   			"widgetCategory",
                    		lv_widgetCategory_14_0, 
                    		"WIDGET_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2778:2: (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==25) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2778:4: otherlv_15= ':' ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,25,FOLLOW_25_in_ruleWidgetConfigurationMdsl5921); 

                        	newLeafNode(otherlv_15, grammarAccess.getWidgetConfigurationMdslAccess().getColonKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2782:1: ( (otherlv_16= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2783:1: (otherlv_16= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2783:1: (otherlv_16= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2784:3: otherlv_16= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5941); 

                    		newLeafNode(otherlv_16, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetTypeWidgetTypeCrossReference_10_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2795:4: ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==38) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2796:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2796:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2797:3: lv_dslReference_17_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl5964);
                    lv_dslReference_17_0=ruleXtextLanguageReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"dslReference",
                            		lv_dslReference_17_0, 
                            		"XtextLanguageReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2813:3: ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=72 && LA51_0<=73)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2813:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2813:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==72) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==73) ) {
                        alt50=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2813:6: otherlv_18= 'flexible template:'
                            {
                            otherlv_18=(Token)match(input,72,FOLLOW_72_in_ruleWidgetConfigurationMdsl5979); 

                                	newLeafNode(otherlv_18, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateKeyword_12_0_0());
                                

                            }
                            break;
                        case 2 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2818:7: otherlv_19= 'target template:'
                            {
                            otherlv_19=(Token)match(input,73,FOLLOW_73_in_ruleWidgetConfigurationMdsl5997); 

                                	newLeafNode(otherlv_19, grammarAccess.getWidgetConfigurationMdslAccess().getTargetTemplateKeyword_12_0_1());
                                

                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2822:2: ( (otherlv_20= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2823:1: (otherlv_20= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2823:1: (otherlv_20= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2824:3: otherlv_20= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_20=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl6018); 

                    		newLeafNode(otherlv_20, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateTypeConfigurationMdslCrossReference_12_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2835:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2837:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2837:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2838:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2841:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2842:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2842:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            loop52:
            do {
                int alt52=3;
                int LA52_0 = input.LA(1);

                if ( LA52_0 ==74 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
                    alt52=1;
                }
                else if ( LA52_0 ==75 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
                    alt52=2;
                }


                switch (alt52) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2844:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2844:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2845:5: {...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2845:121: ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2846:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2849:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2849:7: {...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2849:16: (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2849:18: otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    {
            	    otherlv_22=(Token)match(input,74,FOLLOW_74_in_ruleWidgetConfigurationMdsl6078); 

            	        	newLeafNode(otherlv_22, grammarAccess.getWidgetConfigurationMdslAccess().getVisibleWhenKeyword_13_0_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2853:1: ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2854:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2854:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2855:3: lv_visibilityQuery_23_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getVisibilityQueryQueryParserRuleCall_13_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6099);
            	    lv_visibilityQuery_23_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"visibilityQuery",
            	            		lv_visibilityQuery_23_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2878:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2878:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2879:5: {...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2879:121: ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2880:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2883:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2883:7: {...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2883:16: (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2883:18: otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) )
            	    {
            	    otherlv_24=(Token)match(input,75,FOLLOW_75_in_ruleWidgetConfigurationMdsl6167); 

            	        	newLeafNode(otherlv_24, grammarAccess.getWidgetConfigurationMdslAccess().getEditableWhenKeyword_13_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2887:1: ( (lv_editableQuery_25_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2888:1: (lv_editableQuery_25_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2888:1: (lv_editableQuery_25_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2889:3: lv_editableQuery_25_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getEditableQueryQueryParserRuleCall_13_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6188);
            	    lv_editableQuery_25_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"editableQuery",
            	            		lv_editableQuery_25_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2919:2: (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==66) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2919:4: otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    {
                    otherlv_26=(Token)match(input,66,FOLLOW_66_in_ruleWidgetConfigurationMdsl6242); 

                        	newLeafNode(otherlv_26, grammarAccess.getWidgetConfigurationMdslAccess().getValueKeyword_14_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2923:1: ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2924:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2924:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2925:3: lv_valueQuery_27_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueQueryQueryUsageParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6263);
                    lv_valueQuery_27_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueQuery",
                            		lv_valueQuery_27_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2941:4: (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==76) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2941:6: otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    {
                    otherlv_28=(Token)match(input,76,FOLLOW_76_in_ruleWidgetConfigurationMdsl6278); 

                        	newLeafNode(otherlv_28, grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterKeyword_15_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2945:1: ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2946:1: (lv_valueConverter_29_0= ruleValueConverter )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2946:1: (lv_valueConverter_29_0= ruleValueConverter )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2947:3: lv_valueConverter_29_0= ruleValueConverter
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterValueConverterParserRuleCall_15_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6299);
                    lv_valueConverter_29_0=ruleValueConverter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueConverter",
                            		lv_valueConverter_29_0, 
                            		"ValueConverter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2963:4: (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==77) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2963:6: otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    {
                    otherlv_30=(Token)match(input,77,FOLLOW_77_in_ruleWidgetConfigurationMdsl6314); 

                        	newLeafNode(otherlv_30, grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsKeyword_16_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2967:1: ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==82) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2968:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2968:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2969:3: lv_validators_31_0= ruleValidatorMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsValidatorMdslParserRuleCall_16_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6335);
                    	    lv_validators_31_0=ruleValidatorMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"validators",
                    	            		lv_validators_31_0, 
                    	            		"ValidatorMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2985:5: ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==53) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==78) ) {
                    alt58=1;
                }
            }
            else if ( (LA58_0==78) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2985:6: ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2985:6: ( (lv_i18NFormat_32_0= 'I18N' ) )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==53) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2986:1: (lv_i18NFormat_32_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2986:1: (lv_i18NFormat_32_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2987:3: lv_i18NFormat_32_0= 'I18N'
                            {
                            lv_i18NFormat_32_0=(Token)match(input,53,FOLLOW_53_in_ruleWidgetConfigurationMdsl6357); 

                                    newLeafNode(lv_i18NFormat_32_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NFormatI18NKeyword_17_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NFormat", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_33=(Token)match(input,78,FOLLOW_78_in_ruleWidgetConfigurationMdsl6383); 

                        	newLeafNode(otherlv_33, grammarAccess.getWidgetConfigurationMdslAccess().getFormatKeyword_17_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3004:1: ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3005:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3005:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3006:3: lv_valueFormat_34_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueFormatFormatExprParserRuleCall_17_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6404);
                    lv_valueFormat_34_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueFormat",
                            		lv_valueFormat_34_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3022:4: (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==79) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3022:6: otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    {
                    otherlv_35=(Token)match(input,79,FOLLOW_79_in_ruleWidgetConfigurationMdsl6419); 

                        	newLeafNode(otherlv_35, grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesKeyword_18_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3026:1: ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3027:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3027:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3028:3: lv_candidatesQuery_36_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesQueryQueryUsageParserRuleCall_18_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6440);
                    lv_candidatesQuery_36_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"candidatesQuery",
                            		lv_candidatesQuery_36_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3044:4: ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==53||LA61_0==80) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3044:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3044:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==53) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3045:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3045:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3046:3: lv_i18NItemLabel_37_0= 'I18N'
                            {
                            lv_i18NItemLabel_37_0=(Token)match(input,53,FOLLOW_53_in_ruleWidgetConfigurationMdsl6461); 

                                    newLeafNode(lv_i18NItemLabel_37_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NItemLabelI18NKeyword_19_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NItemLabel", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_38=(Token)match(input,80,FOLLOW_80_in_ruleWidgetConfigurationMdsl6487); 

                        	newLeafNode(otherlv_38, grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelKeyword_19_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3063:1: ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3064:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3064:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3065:3: lv_itemLabelExpression_39_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelExpressionFormatExprParserRuleCall_19_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6508);
                    lv_itemLabelExpression_39_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"itemLabelExpression",
                            		lv_itemLabelExpression_39_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3081:4: (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==81) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3081:6: otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    {
                    otherlv_40=(Token)match(input,81,FOLLOW_81_in_ruleWidgetConfigurationMdsl6523); 

                        	newLeafNode(otherlv_40, grammarAccess.getWidgetConfigurationMdslAccess().getCommandsKeyword_20_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3085:1: ( (lv_commands_41_0= ruleCommand ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3086:1: (lv_commands_41_0= ruleCommand )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3086:1: (lv_commands_41_0= ruleCommand )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3087:3: lv_commands_41_0= ruleCommand
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6544);
                    lv_commands_41_0=ruleCommand();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"commands",
                            		lv_commands_41_0, 
                            		"Command");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3103:2: (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==33) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3103:4: otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) )
                    	    {
                    	    otherlv_42=(Token)match(input,33,FOLLOW_33_in_ruleWidgetConfigurationMdsl6557); 

                    	        	newLeafNode(otherlv_42, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_20_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3107:1: ( (lv_commands_43_0= ruleCommand ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3108:1: (lv_commands_43_0= ruleCommand )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3108:1: (lv_commands_43_0= ruleCommand )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3109:3: lv_commands_43_0= ruleCommand
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6578);
                    	    lv_commands_43_0=ruleCommand();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"commands",
                    	            		lv_commands_43_0, 
                    	            		"Command");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWidgetConfigurationMdsl"


    // $ANTLR start "entryRuleValidatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3133:1: entryRuleValidatorMdsl returns [EObject current=null] : iv_ruleValidatorMdsl= ruleValidatorMdsl EOF ;
    public final EObject entryRuleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3134:2: (iv_ruleValidatorMdsl= ruleValidatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3135:2: iv_ruleValidatorMdsl= ruleValidatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getValidatorMdslRule()); 
            pushFollow(FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6618);
            iv_ruleValidatorMdsl=ruleValidatorMdsl();

            state._fsp--;

             current =iv_ruleValidatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidatorMdsl6628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidatorMdsl"


    // $ANTLR start "ruleValidatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3142:1: ruleValidatorMdsl returns [EObject current=null] : (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) ;
    public final EObject ruleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_i18NMessage_2_0=null;
        Token otherlv_3=null;
        EObject lv_validationQuery_1_0 = null;

        EObject lv_errorMessageExpr_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3145:28: ( (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3146:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3146:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3146:3: otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleValidatorMdsl6665); 

                	newLeafNode(otherlv_0, grammarAccess.getValidatorMdslAccess().getValidationRuleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3150:1: ( (lv_validationQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3151:1: (lv_validationQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3151:1: (lv_validationQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3152:3: lv_validationQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getValidationQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6686);
            lv_validationQuery_1_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValidatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"validationQuery",
                    		lv_validationQuery_1_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3168:2: ( (lv_i18NMessage_2_0= 'I18N' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==53) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3169:1: (lv_i18NMessage_2_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3169:1: (lv_i18NMessage_2_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3170:3: lv_i18NMessage_2_0= 'I18N'
                    {
                    lv_i18NMessage_2_0=(Token)match(input,53,FOLLOW_53_in_ruleValidatorMdsl6704); 

                            newLeafNode(lv_i18NMessage_2_0, grammarAccess.getValidatorMdslAccess().getI18NMessageI18NKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValidatorMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NMessage", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,83,FOLLOW_83_in_ruleValidatorMdsl6730); 

                	newLeafNode(otherlv_3, grammarAccess.getValidatorMdslAccess().getErrorMessageKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3187:1: ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3189:3: lv_errorMessageExpr_4_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getErrorMessageExprFormatExprParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6751);
            lv_errorMessageExpr_4_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValidatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"errorMessageExpr",
                    		lv_errorMessageExpr_4_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidatorMdsl"


    // $ANTLR start "entryRuleCommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3213:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3214:2: (iv_ruleCommand= ruleCommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3215:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand6787);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand6797); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3222:1: ruleCommand returns [EObject current=null] : (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_CommandDefinitionMdsl_0 = null;

        EObject this_CommandRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3225:28: ( (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3226:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3226:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=123 && LA65_0<=125)) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_ID) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3227:5: this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6844);
                    this_CommandDefinitionMdsl_0=ruleCommandDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_CommandDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3237:5: this_CommandRefMdsl_1= ruleCommandRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCommandRefMdsl_in_ruleCommand6871);
                    this_CommandRefMdsl_1=ruleCommandRefMdsl();

                    state._fsp--;

                     
                            current = this_CommandRefMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleCommandDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3253:1: entryRuleCommandDeclaration returns [EObject current=null] : iv_ruleCommandDeclaration= ruleCommandDeclaration EOF ;
    public final EObject entryRuleCommandDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3254:2: (iv_ruleCommandDeclaration= ruleCommandDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3255:2: iv_ruleCommandDeclaration= ruleCommandDeclaration EOF
            {
             newCompositeNode(grammarAccess.getCommandDeclarationRule()); 
            pushFollow(FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6906);
            iv_ruleCommandDeclaration=ruleCommandDeclaration();

            state._fsp--;

             current =iv_ruleCommandDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDeclaration6916); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandDeclaration"


    // $ANTLR start "ruleCommandDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3262:1: ruleCommandDeclaration returns [EObject current=null] : (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) ;
    public final EObject ruleCommandDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_definition_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3265:28: ( (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3266:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3266:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3266:3: otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleCommandDeclaration6953); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandDeclarationAccess().getCommonCommandKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3270:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3271:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3271:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3272:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDeclaration6970); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCommandDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleCommandDeclaration6987); 

                	newLeafNode(otherlv_2, grammarAccess.getCommandDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3292:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==13) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3292:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleCommandDeclaration7000); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3296:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3297:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3297:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3298:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration7017); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getCommandDeclarationAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3314:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==17) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3314:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleCommandDeclaration7037); 

                        	newLeafNode(otherlv_5, grammarAccess.getCommandDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3318:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3319:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3319:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3320:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration7054); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getCommandDeclarationAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3336:4: ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3337:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3337:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3338:3: lv_definition_7_0= ruleCommandDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCommandDeclarationAccess().getDefinitionCommandDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration7082);
            lv_definition_7_0=ruleCommandDefinitionMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_7_0, 
                    		"CommandDefinitionMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleCommandDeclaration7094); 

                	newLeafNode(otherlv_8, grammarAccess.getCommandDeclarationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandDeclaration"


    // $ANTLR start "entryRuleCommandDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3366:1: entryRuleCommandDefinitionMdsl returns [EObject current=null] : iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF ;
    public final EObject entryRuleCommandDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3367:2: (iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3368:2: iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl7130);
            iv_ruleCommandDefinitionMdsl=ruleCommandDefinitionMdsl();

            state._fsp--;

             current =iv_ruleCommandDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl7140); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandDefinitionMdsl"


    // $ANTLR start "ruleCommandDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3375:1: ruleCommandDefinitionMdsl returns [EObject current=null] : ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) ;
    public final EObject ruleCommandDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_i18NLabel_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_category_0_0 = null;

        EObject lv_label_2_0 = null;

        EObject lv_action_6_0 = null;

        EObject lv_onActionSuccessUICommands_8_0 = null;

        EObject lv_onActionErrorUICommands_10_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3378:28: ( ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3379:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3379:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3379:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3379:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3380:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3380:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3381:3: lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getCategoryCOMMAND_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl7186);
            lv_category_0_0=ruleCOMMAND_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"COMMAND_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3397:2: ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_STRING||LA69_0==53||LA69_0==105) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3397:3: ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3397:3: ( (lv_i18NLabel_1_0= 'I18N' ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==53) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:1: (lv_i18NLabel_1_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:1: (lv_i18NLabel_1_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3399:3: lv_i18NLabel_1_0= 'I18N'
                            {
                            lv_i18NLabel_1_0=(Token)match(input,53,FOLLOW_53_in_ruleCommandDefinitionMdsl7205); 

                                    newLeafNode(lv_i18NLabel_1_0, grammarAccess.getCommandDefinitionMdslAccess().getI18NLabelI18NKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3412:3: ( (lv_label_2_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3413:1: (lv_label_2_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3413:1: (lv_label_2_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3414:3: lv_label_2_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getLabelFormatExprParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7240);
                    lv_label_2_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"label",
                            		lv_label_2_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3430:4: (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==85) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3430:6: otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,85,FOLLOW_85_in_ruleCommandDefinitionMdsl7255); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDefinitionMdslAccess().getIconKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3434:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3435:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3435:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3436:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7275); 

                    		newLeafNode(otherlv_4, grammarAccess.getCommandDefinitionMdslAccess().getIconIconDescriptorMdslCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,86,FOLLOW_86_in_ruleCommandDefinitionMdsl7289); 

                	newLeafNode(otherlv_5, grammarAccess.getCommandDefinitionMdslAccess().getActionKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3451:1: ( (lv_action_6_0= ruleQuery ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3452:1: (lv_action_6_0= ruleQuery )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3452:1: (lv_action_6_0= ruleQuery )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3453:3: lv_action_6_0= ruleQuery
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getActionQueryParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7310);
            lv_action_6_0=ruleQuery();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
            	        }
                   		set(
                   			current, 
                   			"action",
                    		lv_action_6_0, 
                    		"Query");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3469:2: (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==87) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3469:4: otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_7=(Token)match(input,87,FOLLOW_87_in_ruleCommandDefinitionMdsl7323); 

                        	newLeafNode(otherlv_7, grammarAccess.getCommandDefinitionMdslAccess().getOnSuccessKeyword_5_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3473:1: ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( ((LA71_0>=91 && LA71_0<=92)) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3474:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3474:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3475:3: lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionSuccessUICommandsUICommandMdslParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7344);
                    	    lv_onActionSuccessUICommands_8_0=ruleUICommandMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onActionSuccessUICommands",
                    	            		lv_onActionSuccessUICommands_8_0, 
                    	            		"UICommandMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3491:5: (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==88) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3491:7: otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_9=(Token)match(input,88,FOLLOW_88_in_ruleCommandDefinitionMdsl7360); 

                        	newLeafNode(otherlv_9, grammarAccess.getCommandDefinitionMdslAccess().getOnErrorKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3495:1: ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( ((LA73_0>=91 && LA73_0<=92)) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3496:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3496:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3497:3: lv_onActionErrorUICommands_10_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionErrorUICommandsUICommandMdslParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7381);
                    	    lv_onActionErrorUICommands_10_0=ruleUICommandMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onActionErrorUICommands",
                    	            		lv_onActionErrorUICommands_10_0, 
                    	            		"UICommandMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandDefinitionMdsl"


    // $ANTLR start "entryRuleCommandRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3521:1: entryRuleCommandRefMdsl returns [EObject current=null] : iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF ;
    public final EObject entryRuleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3522:2: (iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3523:2: iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandRefMdslRule()); 
            pushFollow(FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7420);
            iv_ruleCommandRefMdsl=ruleCommandRefMdsl();

            state._fsp--;

             current =iv_ruleCommandRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandRefMdsl7430); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandRefMdsl"


    // $ANTLR start "ruleCommandRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3530:1: ruleCommandRefMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) ;
    public final EObject ruleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_i18NLabelOverride_2_0=null;
        Token otherlv_4=null;
        EObject lv_labelOverride_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3533:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3534:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3534:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3534:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3534:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3535:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3535:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3536:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandRefMdsl7475); 

            		newLeafNode(otherlv_0, grammarAccess.getCommandRefMdslAccess().getReferencedCommandDeclarationCrossReference_0_0()); 
            	

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3547:2: (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==89) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3547:4: otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_89_in_ruleCommandRefMdsl7488); 

                        	newLeafNode(otherlv_1, grammarAccess.getCommandRefMdslAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3551:1: ( (lv_i18NLabelOverride_2_0= 'I18N' ) )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==53) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3552:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3552:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3553:3: lv_i18NLabelOverride_2_0= 'I18N'
                            {
                            lv_i18NLabelOverride_2_0=(Token)match(input,53,FOLLOW_53_in_ruleCommandRefMdsl7506); 

                                    newLeafNode(lv_i18NLabelOverride_2_0, grammarAccess.getCommandRefMdslAccess().getI18NLabelOverrideI18NKeyword_1_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelOverride", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3566:3: ( (lv_labelOverride_3_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3567:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3567:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3568:3: lv_labelOverride_3_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandRefMdslAccess().getLabelOverrideFormatExprParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7541);
                    lv_labelOverride_3_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandRefMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"labelOverride",
                            		lv_labelOverride_3_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,90,FOLLOW_90_in_ruleCommandRefMdsl7553); 

                        	newLeafNode(otherlv_4, grammarAccess.getCommandRefMdslAccess().getRightParenthesisKeyword_1_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandRefMdsl"


    // $ANTLR start "entryRuleUICommandMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3596:1: entryRuleUICommandMdsl returns [EObject current=null] : iv_ruleUICommandMdsl= ruleUICommandMdsl EOF ;
    public final EObject entryRuleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUICommandMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3597:2: (iv_ruleUICommandMdsl= ruleUICommandMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3598:2: iv_ruleUICommandMdsl= ruleUICommandMdsl EOF
            {
             newCompositeNode(grammarAccess.getUICommandMdslRule()); 
            pushFollow(FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7591);
            iv_ruleUICommandMdsl=ruleUICommandMdsl();

            state._fsp--;

             current =iv_ruleUICommandMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUICommandMdsl7601); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUICommandMdsl"


    // $ANTLR start "ruleUICommandMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3605:1: ruleUICommandMdsl returns [EObject current=null] : (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) ;
    public final EObject ruleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_ReloadWidgetsUICommand_0 = null;

        EObject this_ReloadViewUICommand_1 = null;

        EObject this_DisplayViewUICommand_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3608:28: ( (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3609:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3609:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            int alt77=3;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==92) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==94) ) {
                    alt77=1;
                }
                else if ( (LA77_1==93) ) {
                    alt77=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA77_0==91) ) {
                alt77=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3610:5: this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadWidgetsUICommandParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7648);
                    this_ReloadWidgetsUICommand_0=ruleReloadWidgetsUICommand();

                    state._fsp--;

                     
                            current = this_ReloadWidgetsUICommand_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3620:5: this_ReloadViewUICommand_1= ruleReloadViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadViewUICommandParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7675);
                    this_ReloadViewUICommand_1=ruleReloadViewUICommand();

                    state._fsp--;

                     
                            current = this_ReloadViewUICommand_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3630:5: this_DisplayViewUICommand_2= ruleDisplayViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getDisplayViewUICommandParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7702);
                    this_DisplayViewUICommand_2=ruleDisplayViewUICommand();

                    state._fsp--;

                     
                            current = this_DisplayViewUICommand_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUICommandMdsl"


    // $ANTLR start "entryRuleDisplayViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3646:1: entryRuleDisplayViewUICommand returns [EObject current=null] : iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF ;
    public final EObject entryRuleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisplayViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3647:2: (iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3648:2: iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getDisplayViewUICommandRule()); 
            pushFollow(FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7737);
            iv_ruleDisplayViewUICommand=ruleDisplayViewUICommand();

            state._fsp--;

             current =iv_ruleDisplayViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisplayViewUICommand7747); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisplayViewUICommand"


    // $ANTLR start "ruleDisplayViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3655:1: ruleDisplayViewUICommand returns [EObject current=null] : (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) ;
    public final EObject ruleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_target_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3658:28: ( (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3659:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3659:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3659:3: otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            {
            otherlv_0=(Token)match(input,91,FOLLOW_91_in_ruleDisplayViewUICommand7784); 

                	newLeafNode(otherlv_0, grammarAccess.getDisplayViewUICommandAccess().getDisplayViewKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3663:1: (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==59) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3663:3: otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) )
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleDisplayViewUICommand7797); 

                        	newLeafNode(otherlv_1, grammarAccess.getDisplayViewUICommandAccess().getForKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3667:1: ( (lv_target_2_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3668:1: (lv_target_2_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3668:1: (lv_target_2_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3669:3: lv_target_2_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getDisplayViewUICommandAccess().getTargetQueryUsageParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7818);
                    lv_target_2_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDisplayViewUICommandRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_2_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisplayViewUICommand"


    // $ANTLR start "entryRuleReloadViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3693:1: entryRuleReloadViewUICommand returns [EObject current=null] : iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF ;
    public final EObject entryRuleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3694:2: (iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3695:2: iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadViewUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7856);
            iv_ruleReloadViewUICommand=ruleReloadViewUICommand();

            state._fsp--;

             current =iv_ruleReloadViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadViewUICommand7866); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReloadViewUICommand"


    // $ANTLR start "ruleReloadViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3702:1: ruleReloadViewUICommand returns [EObject current=null] : ( () otherlv_1= 'Reload' otherlv_2= 'view' ) ;
    public final EObject ruleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3705:28: ( ( () otherlv_1= 'Reload' otherlv_2= 'view' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3706:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3706:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3706:2: () otherlv_1= 'Reload' otherlv_2= 'view'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3706:2: ()
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3707:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReloadViewUICommandAccess().getReloadViewUICommandAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,92,FOLLOW_92_in_ruleReloadViewUICommand7912); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadViewUICommandAccess().getReloadKeyword_1());
                
            otherlv_2=(Token)match(input,93,FOLLOW_93_in_ruleReloadViewUICommand7924); 

                	newLeafNode(otherlv_2, grammarAccess.getReloadViewUICommandAccess().getViewKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReloadViewUICommand"


    // $ANTLR start "entryRuleReloadWidgetsUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3728:1: entryRuleReloadWidgetsUICommand returns [EObject current=null] : iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF ;
    public final EObject entryRuleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadWidgetsUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3729:2: (iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3730:2: iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadWidgetsUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand7960);
            iv_ruleReloadWidgetsUICommand=ruleReloadWidgetsUICommand();

            state._fsp--;

             current =iv_ruleReloadWidgetsUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand7970); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReloadWidgetsUICommand"


    // $ANTLR start "ruleReloadWidgetsUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3737:1: ruleReloadWidgetsUICommand returns [EObject current=null] : (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) ;
    public final EObject ruleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3740:28: ( (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3741:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3741:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3741:3: otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,92,FOLLOW_92_in_ruleReloadWidgetsUICommand8007); 

                	newLeafNode(otherlv_0, grammarAccess.getReloadWidgetsUICommandAccess().getReloadKeyword_0());
                
            otherlv_1=(Token)match(input,94,FOLLOW_94_in_ruleReloadWidgetsUICommand8019); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3749:1: ( (otherlv_2= RULE_ID ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_ID) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3750:1: (otherlv_2= RULE_ID )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3750:1: (otherlv_2= RULE_ID )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3751:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReloadWidgetsUICommandRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand8039); 

            	    		newLeafNode(otherlv_2, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsToReloadWidgetConfigurationMdslCrossReference_2_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReloadWidgetsUICommand"


    // $ANTLR start "entryRuleQueryUsage"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3770:1: entryRuleQueryUsage returns [EObject current=null] : iv_ruleQueryUsage= ruleQueryUsage EOF ;
    public final EObject entryRuleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryUsage = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3771:2: (iv_ruleQueryUsage= ruleQueryUsage EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3772:2: iv_ruleQueryUsage= ruleQueryUsage EOF
            {
             newCompositeNode(grammarAccess.getQueryUsageRule()); 
            pushFollow(FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage8076);
            iv_ruleQueryUsage=ruleQueryUsage();

            state._fsp--;

             current =iv_ruleQueryUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryUsage8086); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryUsage"


    // $ANTLR start "ruleQueryUsage"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3779:1: ruleQueryUsage returns [EObject current=null] : (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) ;
    public final EObject ruleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject this_Query_0 = null;

        EObject this_QueryChain_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3782:28: ( (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3783:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3783:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_ID)||(LA80_0>=96 && LA80_0<=98)||LA80_0==101||LA80_0==105) ) {
                alt80=1;
            }
            else if ( (LA80_0==103) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3784:5: this_Query_0= ruleQuery
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQuery_in_ruleQueryUsage8133);
                    this_Query_0=ruleQuery();

                    state._fsp--;

                     
                            current = this_Query_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3794:5: this_QueryChain_1= ruleQueryChain
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryChainParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryChain_in_ruleQueryUsage8160);
                    this_QueryChain_1=ruleQueryChain();

                    state._fsp--;

                     
                            current = this_QueryChain_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryUsage"


    // $ANTLR start "entryRuleQuery"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3810:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3811:2: (iv_ruleQuery= ruleQuery EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3812:2: iv_ruleQuery= ruleQuery EOF
            {
             newCompositeNode(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_ruleQuery_in_entryRuleQuery8195);
            iv_ruleQuery=ruleQuery();

            state._fsp--;

             current =iv_ruleQuery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQuery8205); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3819:1: ruleQuery returns [EObject current=null] : (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        EObject this_QueryDefinitionMdsl_0 = null;

        EObject this_QueryRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3822:28: ( (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3823:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3823:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_STRING||(LA81_0>=96 && LA81_0<=98)||LA81_0==101||LA81_0==105) ) {
                alt81=1;
            }
            else if ( (LA81_0==RULE_ID) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3824:5: this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8252);
                    this_QueryDefinitionMdsl_0=ruleQueryDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_QueryDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3834:5: this_QueryRefMdsl_1= ruleQueryRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryRefMdsl_in_ruleQuery8279);
                    this_QueryRefMdsl_1=ruleQueryRefMdsl();

                    state._fsp--;

                     
                            current = this_QueryRefMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleQueryDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3850:1: entryRuleQueryDeclaration returns [EObject current=null] : iv_ruleQueryDeclaration= ruleQueryDeclaration EOF ;
    public final EObject entryRuleQueryDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3851:2: (iv_ruleQueryDeclaration= ruleQueryDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3852:2: iv_ruleQueryDeclaration= ruleQueryDeclaration EOF
            {
             newCompositeNode(grammarAccess.getQueryDeclarationRule()); 
            pushFollow(FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8314);
            iv_ruleQueryDeclaration=ruleQueryDeclaration();

            state._fsp--;

             current =iv_ruleQueryDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDeclaration8324); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryDeclaration"


    // $ANTLR start "ruleQueryDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3859:1: ruleQueryDeclaration returns [EObject current=null] : (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) ;
    public final EObject ruleQueryDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_definition_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3862:28: ( (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3863:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3863:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3863:3: otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_95_in_ruleQueryDeclaration8361); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryDeclarationAccess().getCommonQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3868:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3868:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3869:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDeclaration8378); 

            			newLeafNode(lv_name_1_0, grammarAccess.getQueryDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleQueryDeclaration8395); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3889:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==13) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3889:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleQueryDeclaration8408); 

                        	newLeafNode(otherlv_3, grammarAccess.getQueryDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3893:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3894:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3894:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3895:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8425); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getQueryDeclarationAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3911:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==17) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3911:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleQueryDeclaration8445); 

                        	newLeafNode(otherlv_5, grammarAccess.getQueryDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3915:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3916:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3916:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3917:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8462); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getQueryDeclarationAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3933:4: ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3934:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3934:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3935:3: lv_definition_7_0= ruleQueryDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryDeclarationAccess().getDefinitionQueryDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8490);
            lv_definition_7_0=ruleQueryDefinitionMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_7_0, 
                    		"QueryDefinitionMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleQueryDeclaration8502); 

                	newLeafNode(otherlv_8, grammarAccess.getQueryDeclarationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryDeclaration"


    // $ANTLR start "entryRuleQueryDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3963:1: entryRuleQueryDefinitionMdsl returns [EObject current=null] : iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF ;
    public final EObject entryRuleQueryDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3964:2: (iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3965:2: iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8538);
            iv_ruleQueryDefinitionMdsl=ruleQueryDefinitionMdsl();

            state._fsp--;

             current =iv_ruleQueryDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8548); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryDefinitionMdsl"


    // $ANTLR start "ruleQueryDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3972:1: ruleQueryDefinitionMdsl returns [EObject current=null] : ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) ;
    public final EObject ruleQueryDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_contextLocator_5_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_query_6_0 = null;

        EObject lv_externalQueryCall_7_0 = null;

        EObject lv_properties_11_0 = null;

        EObject lv_properties_13_0 = null;

        Enumerator lv_optimisationLevel_15_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3975:28: ( ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3976:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3976:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3976:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3976:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==96) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3976:4: otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,96,FOLLOW_96_in_ruleQueryDefinitionMdsl8586); 

                        	newLeafNode(otherlv_0, grammarAccess.getQueryDefinitionMdslAccess().getLanguageKeyword_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3980:1: ( (otherlv_1= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3981:1: (otherlv_1= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3981:1: (otherlv_1= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3982:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8606); 

                    		newLeafNode(otherlv_1, grammarAccess.getQueryDefinitionMdslAccess().getEvaluatorQueryEvaluatorMdslCrossReference_0_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3993:4: (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==97) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3993:6: otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,97,FOLLOW_97_in_ruleQueryDefinitionMdsl8621); 

                        	newLeafNode(otherlv_2, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3997:1: ( (otherlv_3= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3998:1: (otherlv_3= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3998:1: (otherlv_3= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3999:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8641); 

                    		newLeafNode(otherlv_3, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelForeignModelMdslCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4010:4: (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==98) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4010:6: otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,98,FOLLOW_98_in_ruleQueryDefinitionMdsl8656); 

                        	newLeafNode(otherlv_4, grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4014:1: ( (lv_contextLocator_5_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4015:1: (lv_contextLocator_5_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4015:1: (lv_contextLocator_5_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4016:3: lv_contextLocator_5_0= RULE_STRING
                    {
                    lv_contextLocator_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8673); 

                    			newLeafNode(lv_contextLocator_5_0, grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"contextLocator",
                            		lv_contextLocator_5_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4032:4: ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_STRING||LA87_0==105) ) {
                alt87=1;
            }
            else if ( (LA87_0==101) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4032:5: ( (lv_query_6_0= ruleQueryBody ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4032:5: ( (lv_query_6_0= ruleQueryBody ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4033:1: (lv_query_6_0= ruleQueryBody )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4033:1: (lv_query_6_0= ruleQueryBody )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4034:3: lv_query_6_0= ruleQueryBody
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getQueryQueryBodyParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8702);
                    lv_query_6_0=ruleQueryBody();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"query",
                            		lv_query_6_0, 
                            		"QueryBody");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4052:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4052:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4053:3: lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getExternalQueryCallExternalQueryCallMdslParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8729);
                    lv_externalQueryCall_7_0=ruleExternalQueryCallMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"externalQueryCall",
                            		lv_externalQueryCall_7_0, 
                            		"ExternalQueryCallMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4069:3: (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==25) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4069:5: otherlv_8= ':' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleQueryDefinitionMdsl8743); 

                        	newLeafNode(otherlv_8, grammarAccess.getQueryDefinitionMdslAccess().getColonKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4073:1: ( (otherlv_9= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4074:1: (otherlv_9= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4074:1: (otherlv_9= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4075:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8763); 

                    		newLeafNode(otherlv_9, grammarAccess.getQueryDefinitionMdslAccess().getReturnTypeEClassifierCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4086:4: (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==99) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4086:6: otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    {
                    otherlv_10=(Token)match(input,99,FOLLOW_99_in_ruleQueryDefinitionMdsl8778); 

                        	newLeafNode(otherlv_10, grammarAccess.getQueryDefinitionMdslAccess().getPropertiesKeyword_5_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4090:1: ( (lv_properties_11_0= rulePropertyMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4091:1: (lv_properties_11_0= rulePropertyMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4091:1: (lv_properties_11_0= rulePropertyMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4092:3: lv_properties_11_0= rulePropertyMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8799);
                    lv_properties_11_0=rulePropertyMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"properties",
                            		lv_properties_11_0, 
                            		"PropertyMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4108:2: (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==33) ) {
                            int LA89_2 = input.LA(2);

                            if ( (LA89_2==RULE_ID) ) {
                                int LA89_3 = input.LA(3);

                                if ( (LA89_3==14) ) {
                                    alt89=1;
                                }


                            }


                        }


                        switch (alt89) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4108:4: otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    {
                    	    otherlv_12=(Token)match(input,33,FOLLOW_33_in_ruleQueryDefinitionMdsl8812); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getQueryDefinitionMdslAccess().getCommaKeyword_5_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4112:1: ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4113:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4113:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4114:3: lv_properties_13_0= rulePropertyMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8833);
                    	    lv_properties_13_0=rulePropertyMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"properties",
                    	            		lv_properties_13_0, 
                    	            		"PropertyMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4130:6: (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==100) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4130:8: otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    {
                    otherlv_14=(Token)match(input,100,FOLLOW_100_in_ruleQueryDefinitionMdsl8850); 

                        	newLeafNode(otherlv_14, grammarAccess.getQueryDefinitionMdslAccess().getOptimisationKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4134:1: ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4135:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4135:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4136:3: lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getOptimisationLevelQUERY_OPTIMISATION_LEVELEnumRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8871);
                    lv_optimisationLevel_15_0=ruleQUERY_OPTIMISATION_LEVEL();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"optimisationLevel",
                            		lv_optimisationLevel_15_0, 
                            		"QUERY_OPTIMISATION_LEVEL");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryDefinitionMdsl"


    // $ANTLR start "entryRuleQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4160:1: entryRuleQueryFragment returns [EObject current=null] : iv_ruleQueryFragment= ruleQueryFragment EOF ;
    public final EObject entryRuleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4161:2: (iv_ruleQueryFragment= ruleQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4162:2: iv_ruleQueryFragment= ruleQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8909);
            iv_ruleQueryFragment=ruleQueryFragment();

            state._fsp--;

             current =iv_ruleQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryFragment8919); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryFragment"


    // $ANTLR start "ruleQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4169:1: ruleQueryFragment returns [EObject current=null] : (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralQueryFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4172:28: ( (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4173:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4173:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_STRING) ) {
                alt92=1;
            }
            else if ( (LA92_0==105) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4174:5: this_LiteralQueryFragment_0= ruleLiteralQueryFragment
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getLiteralQueryFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment8966);
                    this_LiteralQueryFragment_0=ruleLiteralQueryFragment();

                    state._fsp--;

                     
                            current = this_LiteralQueryFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4184:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleQueryFragment8993);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryFragment"


    // $ANTLR start "entryRuleLiteralQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4200:1: entryRuleLiteralQueryFragment returns [EObject current=null] : iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF ;
    public final EObject entryRuleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4201:2: (iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4202:2: iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment9028);
            iv_ruleLiteralQueryFragment=ruleLiteralQueryFragment();

            state._fsp--;

             current =iv_ruleLiteralQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralQueryFragment9038); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralQueryFragment"


    // $ANTLR start "ruleLiteralQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4209:1: ruleLiteralQueryFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4212:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4213:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4213:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4214:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4214:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4215:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment9079); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralQueryFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralQueryFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralQueryFragment"


    // $ANTLR start "entryRuleQueryBody"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4239:1: entryRuleQueryBody returns [EObject current=null] : iv_ruleQueryBody= ruleQueryBody EOF ;
    public final EObject entryRuleQueryBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBody = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4240:2: (iv_ruleQueryBody= ruleQueryBody EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4241:2: iv_ruleQueryBody= ruleQueryBody EOF
            {
             newCompositeNode(grammarAccess.getQueryBodyRule()); 
            pushFollow(FOLLOW_ruleQueryBody_in_entryRuleQueryBody9119);
            iv_ruleQueryBody=ruleQueryBody();

            state._fsp--;

             current =iv_ruleQueryBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBody9129); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryBody"


    // $ANTLR start "ruleQueryBody"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4248:1: ruleQueryBody returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) ;
    public final EObject ruleQueryBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4251:28: ( ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4252:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4252:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4252:2: ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4252:2: ( (lv_fragments_0_0= ruleQueryFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4253:1: (lv_fragments_0_0= ruleQueryFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4253:1: (lv_fragments_0_0= ruleQueryFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4254:3: lv_fragments_0_0= ruleQueryFragment
            {
             
            	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody9175);
            lv_fragments_0_0=ruleQueryFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryBodyRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"QueryFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4270:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==15) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4270:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleQueryBody9188); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQueryBodyAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4274:1: ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4275:1: (lv_fragments_2_0= ruleQueryFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4275:1: (lv_fragments_2_0= ruleQueryFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4276:3: lv_fragments_2_0= ruleQueryFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody9209);
            	    lv_fragments_2_0=ruleQueryFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"QueryFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryBody"


    // $ANTLR start "entryRuleQueryRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4300:1: entryRuleQueryRefMdsl returns [EObject current=null] : iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF ;
    public final EObject entryRuleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4301:2: (iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4302:2: iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryRefMdslRule()); 
            pushFollow(FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9247);
            iv_ruleQueryRefMdsl=ruleQueryRefMdsl();

            state._fsp--;

             current =iv_ruleQueryRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryRefMdsl9257); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryRefMdsl"


    // $ANTLR start "ruleQueryRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4309:1: ruleQueryRefMdsl returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4312:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4313:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4313:1: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4314:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4314:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4315:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryRefMdsl9301); 

            		newLeafNode(otherlv_0, grammarAccess.getQueryRefMdslAccess().getReferencedQueryDeclarationCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryRefMdsl"


    // $ANTLR start "entryRuleExternalQueryCallMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4334:1: entryRuleExternalQueryCallMdsl returns [EObject current=null] : iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF ;
    public final EObject entryRuleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalQueryCallMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4335:2: (iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4336:2: iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF
            {
             newCompositeNode(grammarAccess.getExternalQueryCallMdslRule()); 
            pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9336);
            iv_ruleExternalQueryCallMdsl=ruleExternalQueryCallMdsl();

            state._fsp--;

             current =iv_ruleExternalQueryCallMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9346); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalQueryCallMdsl"


    // $ANTLR start "ruleExternalQueryCallMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4343:1: ruleExternalQueryCallMdsl returns [EObject current=null] : (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) ;
    public final EObject ruleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4346:28: ( (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4347:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4347:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4347:3: otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_101_in_ruleExternalQueryCallMdsl9383); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalQueryCallMdslAccess().getCallKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4351:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4352:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4352:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalQueryCallMdslRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9403); 

            		newLeafNode(otherlv_1, grammarAccess.getExternalQueryCallMdslAccess().getExternalQueryEObjectCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,102,FOLLOW_102_in_ruleExternalQueryCallMdsl9415); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalQueryCallMdslAccess().getLeftParenthesisRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalQueryCallMdsl"


    // $ANTLR start "entryRuleQueryChain"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4376:1: entryRuleQueryChain returns [EObject current=null] : iv_ruleQueryChain= ruleQueryChain EOF ;
    public final EObject entryRuleQueryChain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryChain = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4377:2: (iv_ruleQueryChain= ruleQueryChain EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4378:2: iv_ruleQueryChain= ruleQueryChain EOF
            {
             newCompositeNode(grammarAccess.getQueryChainRule()); 
            pushFollow(FOLLOW_ruleQueryChain_in_entryRuleQueryChain9451);
            iv_ruleQueryChain=ruleQueryChain();

            state._fsp--;

             current =iv_ruleQueryChain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryChain9461); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryChain"


    // $ANTLR start "ruleQueryChain"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4385:1: ruleQueryChain returns [EObject current=null] : (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleQueryChain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_queries_2_0 = null;

        EObject lv_queries_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4388:28: ( (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4389:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4389:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4389:3: otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_103_in_ruleQueryChain9498); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryChainAccess().getQueryChainKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryChain9510); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryChainAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4397:1: ( (lv_queries_2_0= ruleQuery ) )+
            int cnt94=0;
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( ((LA94_0>=RULE_STRING && LA94_0<=RULE_ID)||(LA94_0>=96 && LA94_0<=98)||LA94_0==101||LA94_0==105) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4398:1: (lv_queries_2_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4398:1: (lv_queries_2_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4399:3: lv_queries_2_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9531);
            	    lv_queries_2_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryChainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"queries",
            	            		lv_queries_2_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt94 >= 1 ) break loop94;
                        EarlyExitException eee =
                            new EarlyExitException(94, input);
                        throw eee;
                }
                cnt94++;
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4415:3: (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==33) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4415:5: otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleQueryChain9545); 

            	        	newLeafNode(otherlv_3, grammarAccess.getQueryChainAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4419:1: ( (lv_queries_4_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4420:1: (lv_queries_4_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4420:1: (lv_queries_4_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4421:3: lv_queries_4_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9566);
            	    lv_queries_4_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryChainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"queries",
            	            		lv_queries_4_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleQueryChain9580); 

                	newLeafNode(otherlv_5, grammarAccess.getQueryChainAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryChain"


    // $ANTLR start "entryRuleFormatExpr"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4449:1: entryRuleFormatExpr returns [EObject current=null] : iv_ruleFormatExpr= ruleFormatExpr EOF ;
    public final EObject entryRuleFormatExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExpr = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4450:2: (iv_ruleFormatExpr= ruleFormatExpr EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4451:2: iv_ruleFormatExpr= ruleFormatExpr EOF
            {
             newCompositeNode(grammarAccess.getFormatExprRule()); 
            pushFollow(FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9616);
            iv_ruleFormatExpr=ruleFormatExpr();

            state._fsp--;

             current =iv_ruleFormatExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExpr9626); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormatExpr"


    // $ANTLR start "ruleFormatExpr"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4458:1: ruleFormatExpr returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) ;
    public final EObject ruleFormatExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4461:28: ( ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4462:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4462:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4462:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4462:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4463:1: (lv_fragments_0_0= ruleFormatExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4463:1: (lv_fragments_0_0= ruleFormatExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4464:3: lv_fragments_0_0= ruleFormatExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9672);
            lv_fragments_0_0=ruleFormatExprFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFormatExprRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"FormatExprFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4480:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==15) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4480:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleFormatExpr9685); 

            	        	newLeafNode(otherlv_1, grammarAccess.getFormatExprAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4484:1: ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4485:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4485:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4486:3: lv_fragments_2_0= ruleFormatExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9706);
            	    lv_fragments_2_0=ruleFormatExprFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFormatExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"FormatExprFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormatExpr"


    // $ANTLR start "entryRuleFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4510:1: entryRuleFormatExprFragment returns [EObject current=null] : iv_ruleFormatExprFragment= ruleFormatExprFragment EOF ;
    public final EObject entryRuleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4511:2: (iv_ruleFormatExprFragment= ruleFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4512:2: iv_ruleFormatExprFragment= ruleFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9744);
            iv_ruleFormatExprFragment=ruleFormatExprFragment();

            state._fsp--;

             current =iv_ruleFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExprFragment9754); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormatExprFragment"


    // $ANTLR start "ruleFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4519:1: ruleFormatExprFragment returns [EObject current=null] : (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralFormatExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4522:28: ( (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4523:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4523:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_STRING) ) {
                alt97=1;
            }
            else if ( (LA97_0==105) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4524:5: this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getLiteralFormatExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9801);
                    this_LiteralFormatExprFragment_0=ruleLiteralFormatExprFragment();

                    state._fsp--;

                     
                            current = this_LiteralFormatExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4534:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9828);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormatExprFragment"


    // $ANTLR start "entryRuleLiteralFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4550:1: entryRuleLiteralFormatExprFragment returns [EObject current=null] : iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF ;
    public final EObject entryRuleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4551:2: (iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4552:2: iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9863);
            iv_ruleLiteralFormatExprFragment=ruleLiteralFormatExprFragment();

            state._fsp--;

             current =iv_ruleLiteralFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9873); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFormatExprFragment"


    // $ANTLR start "ruleLiteralFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4559:1: ruleLiteralFormatExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4562:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4563:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4563:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4564:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4564:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4565:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9914); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralFormatExprFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralFormatExprFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFormatExprFragment"


    // $ANTLR start "entryRuleTextMacro"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4589:1: entryRuleTextMacro returns [EObject current=null] : iv_ruleTextMacro= ruleTextMacro EOF ;
    public final EObject entryRuleTextMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacro = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4590:2: (iv_ruleTextMacro= ruleTextMacro EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4591:2: iv_ruleTextMacro= ruleTextMacro EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRule()); 
            pushFollow(FOLLOW_ruleTextMacro_in_entryRuleTextMacro9954);
            iv_ruleTextMacro=ruleTextMacro();

            state._fsp--;

             current =iv_ruleTextMacro; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacro9964); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextMacro"


    // $ANTLR start "ruleTextMacro"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4598:1: ruleTextMacro returns [EObject current=null] : (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleTextMacro() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        Token lv_macroValue_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4601:28: ( (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4602:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4602:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4602:3: otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,104,FOLLOW_104_in_ruleTextMacro10001); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroAccess().getMacroKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4606:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4607:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4607:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4608:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacro10018); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTextMacroAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTextMacro10035); 

                	newLeafNode(otherlv_2, grammarAccess.getTextMacroAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4628:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==13) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4628:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleTextMacro10048); 

                        	newLeafNode(otherlv_3, grammarAccess.getTextMacroAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4632:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4633:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4633:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4634:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10065); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getTextMacroAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextMacroRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4650:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==17) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4650:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleTextMacro10085); 

                        	newLeafNode(otherlv_5, grammarAccess.getTextMacroAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4654:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4655:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4655:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4656:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10102); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getTextMacroAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextMacroRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,66,FOLLOW_66_in_ruleTextMacro10121); 

                	newLeafNode(otherlv_7, grammarAccess.getTextMacroAccess().getValueKeyword_5());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4676:1: ( (lv_macroValue_8_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4677:1: (lv_macroValue_8_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4677:1: (lv_macroValue_8_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4678:3: lv_macroValue_8_0= RULE_STRING
            {
            lv_macroValue_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10138); 

            			newLeafNode(lv_macroValue_8_0, grammarAccess.getTextMacroAccess().getMacroValueSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"macroValue",
                    		lv_macroValue_8_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_9=(Token)match(input,28,FOLLOW_28_in_ruleTextMacro10155); 

                	newLeafNode(otherlv_9, grammarAccess.getTextMacroAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextMacro"


    // $ANTLR start "entryRuleTextMacroRef"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4706:1: entryRuleTextMacroRef returns [EObject current=null] : iv_ruleTextMacroRef= ruleTextMacroRef EOF ;
    public final EObject entryRuleTextMacroRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacroRef = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4707:2: (iv_ruleTextMacroRef= ruleTextMacroRef EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4708:2: iv_ruleTextMacroRef= ruleTextMacroRef EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRefRule()); 
            pushFollow(FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef10191);
            iv_ruleTextMacroRef=ruleTextMacroRef();

            state._fsp--;

             current =iv_ruleTextMacroRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacroRef10201); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextMacroRef"


    // $ANTLR start "ruleTextMacroRef"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4715:1: ruleTextMacroRef returns [EObject current=null] : (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTextMacroRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4718:28: ( (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4719:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4719:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4719:3: otherlv_0= '#' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,105,FOLLOW_105_in_ruleTextMacroRef10238); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroRefAccess().getNumberSignKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4723:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4724:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4724:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4725:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRefRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacroRef10258); 

            		newLeafNode(otherlv_1, grammarAccess.getTextMacroRefAccess().getReferencedTextMacroCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextMacroRef"


    // $ANTLR start "ruleVALUE_CONVERTER_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4744:1: ruleVALUE_CONVERTER_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) ;
    public final Enumerator ruleVALUE_CONVERTER_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4746:28: ( ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4747:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4747:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            int alt100=6;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt100=1;
                }
                break;
            case 107:
                {
                alt100=2;
                }
                break;
            case 108:
                {
                alt100=3;
                }
                break;
            case 109:
                {
                alt100=4;
                }
                break;
            case 110:
                {
                alt100=5;
                }
                break;
            case 111:
                {
                alt100=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4747:2: (enumLiteral_0= 'DATE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4747:2: (enumLiteral_0= 'DATE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4747:4: enumLiteral_0= 'DATE'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_106_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10308); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4753:6: (enumLiteral_1= 'DATETIME' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4753:6: (enumLiteral_1= 'DATETIME' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4753:8: enumLiteral_1= 'DATETIME'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_107_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10325); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4759:6: (enumLiteral_2= 'INTEGER' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4759:6: (enumLiteral_2= 'INTEGER' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4759:8: enumLiteral_2= 'INTEGER'
                    {
                    enumLiteral_2=(Token)match(input,108,FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10342); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4765:6: (enumLiteral_3= 'FLOAT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4765:6: (enumLiteral_3= 'FLOAT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4765:8: enumLiteral_3= 'FLOAT'
                    {
                    enumLiteral_3=(Token)match(input,109,FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10359); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4771:6: (enumLiteral_4= 'DOUBLE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4771:6: (enumLiteral_4= 'DOUBLE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4771:8: enumLiteral_4= 'DOUBLE'
                    {
                    enumLiteral_4=(Token)match(input,110,FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10376); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4777:6: (enumLiteral_5= 'XTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4777:6: (enumLiteral_5= 'XTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4777:8: enumLiteral_5= 'XTEXT'
                    {
                    enumLiteral_5=(Token)match(input,111,FOLLOW_111_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10393); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getXTEXTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getXTEXTEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVALUE_CONVERTER_CATEGORY_MDSL"


    // $ANTLR start "ruleWIDGET_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4787:1: ruleWIDGET_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) ;
    public final Enumerator ruleWIDGET_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4789:28: ( ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            int alt101=11;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt101=1;
                }
                break;
            case 113:
                {
                alt101=2;
                }
                break;
            case 114:
                {
                alt101=3;
                }
                break;
            case 115:
                {
                alt101=4;
                }
                break;
            case 116:
                {
                alt101=5;
                }
                break;
            case 117:
                {
                alt101=6;
                }
                break;
            case 118:
                {
                alt101=7;
                }
                break;
            case 119:
                {
                alt101=8;
                }
                break;
            case 120:
                {
                alt101=9;
                }
                break;
            case 121:
                {
                alt101=10;
                }
                break;
            case 122:
                {
                alt101=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:4: enumLiteral_0= 'OUTPUTTEXT_WIDGET'
                    {
                    enumLiteral_0=(Token)match(input,112,FOLLOW_112_in_ruleWIDGET_CATEGORY_MDSL10438); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:8: enumLiteral_1= 'NAVIGATION_WIDGET'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_113_in_ruleWIDGET_CATEGORY_MDSL10455); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4802:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4802:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4802:8: enumLiteral_2= 'TEXT_WIDGET'
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10472); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4808:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4808:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4808:8: enumLiteral_3= 'BOOL_WIDGET'
                    {
                    enumLiteral_3=(Token)match(input,115,FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10489); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4814:6: (enumLiteral_4= 'DATE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4814:6: (enumLiteral_4= 'DATE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4814:8: enumLiteral_4= 'DATE_WIDGET'
                    {
                    enumLiteral_4=(Token)match(input,116,FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10506); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4820:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4820:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4820:8: enumLiteral_5= 'NUMBER_WIDGET'
                    {
                    enumLiteral_5=(Token)match(input,117,FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10523); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4826:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4826:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4826:8: enumLiteral_6= 'SINGLE_SELECT_WIDGET'
                    {
                    enumLiteral_6=(Token)match(input,118,FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10540); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4832:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4832:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4832:8: enumLiteral_7= 'MULTI_SELECT_WIDGET'
                    {
                    enumLiteral_7=(Token)match(input,119,FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10557); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4838:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4838:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4838:8: enumLiteral_8= 'XTEXT_EDITOR'
                    {
                    enumLiteral_8=(Token)match(input,120,FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10574); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4844:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4844:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4844:8: enumLiteral_9= 'XTEXT_TEXT_EDITOR'
                    {
                    enumLiteral_9=(Token)match(input,121,FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10591); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4850:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4850:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4850:8: enumLiteral_10= 'FLEXIBLE_WIDGET'
                    {
                    enumLiteral_10=(Token)match(input,122,FOLLOW_122_in_ruleWIDGET_CATEGORY_MDSL10608); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getFLEXIBLE_WIDGETEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getFLEXIBLE_WIDGETEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWIDGET_CATEGORY_MDSL"


    // $ANTLR start "ruleCOMMAND_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4860:1: ruleCOMMAND_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) ;
    public final Enumerator ruleCOMMAND_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4862:28: ( ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt102=1;
                }
                break;
            case 124:
                {
                alt102=2;
                }
                break;
            case 125:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:4: enumLiteral_0= 'UPDATE_COMMAND'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_123_in_ruleCOMMAND_CATEGORY_MDSL10653); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:8: enumLiteral_1= 'GLOBAL_COMMAND'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_124_in_ruleCOMMAND_CATEGORY_MDSL10670); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4875:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4875:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4875:8: enumLiteral_2= 'ITEM_COMMAND'
                    {
                    enumLiteral_2=(Token)match(input,125,FOLLOW_125_in_ruleCOMMAND_CATEGORY_MDSL10687); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getITEM_COMMANDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getITEM_COMMANDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOMMAND_CATEGORY_MDSL"


    // $ANTLR start "ruleQUERY_OPTIMISATION_LEVEL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4885:1: ruleQUERY_OPTIMISATION_LEVEL returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) ;
    public final Enumerator ruleQUERY_OPTIMISATION_LEVEL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4887:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            int alt103=3;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt103=1;
                }
                break;
            case 127:
                {
                alt103=2;
                }
                break;
            case 128:
                {
                alt103=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:2: (enumLiteral_0= 'NONE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,126,FOLLOW_126_in_ruleQUERY_OPTIMISATION_LEVEL10732); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:6: (enumLiteral_1= 'VIEW' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:6: (enumLiteral_1= 'VIEW' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:8: enumLiteral_1= 'VIEW'
                    {
                    enumLiteral_1=(Token)match(input,127,FOLLOW_127_in_ruleQUERY_OPTIMISATION_LEVEL10749); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4900:6: (enumLiteral_2= 'CONTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4900:6: (enumLiteral_2= 'CONTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4900:8: enumLiteral_2= 'CONTEXT'
                    {
                    enumLiteral_2=(Token)match(input,128,FOLLOW_128_in_ruleQUERY_OPTIMISATION_LEVEL10766); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getCONTEXTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getCONTEXTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQUERY_OPTIMISATION_LEVEL"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMADConfiguration_in_entryRuleMADConfiguration75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMADConfiguration85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMADConfiguration131 = new BitSet(new long[]{0x0644428400310802L,0x0000010080100000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_ruleMADConfiguration153 = new BitSet(new long[]{0x0644428400310002L,0x0000010080100000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_entryRuleMADConfigElement190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMADConfigElement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleMADConfigElement247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_ruleMADConfigElement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_ruleMADConfigElement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_ruleMADConfigElement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOCLCustomLibraryMdsl_in_ruleMADConfigElement355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_ruleMADConfigElement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_ruleMADConfigElement517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassDescriptorMdsl721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl763 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleClassDescriptorMdsl781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyTypeMdsl851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyTypeMdsl893 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePropertyTypeMdsl910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyMdsl978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyMdsl1023 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePropertyMdsl1035 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValueMdsl1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1148 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_rulePropertyValueMdsl1161 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1182 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropValueExprFragment1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIconDescriptorMdsl1477 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1494 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleIconDescriptorMdsl1512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1529 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleIconDescriptorMdsl1550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIconDescriptorMdsl1591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleI18NBundleMdsl1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleI18NBundleMdsl1698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1715 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleI18NBundleMdsl1733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1750 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleI18NBundleMdsl1771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleI18NBundleMdsl1812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForeignModelMdsl1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleForeignModelMdsl1919 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleForeignModelMdsl1931 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleForeignModelMdsl1943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForeignModelMdsl1960 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleForeignModelMdsl1977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1994 = new BitSet(new long[]{0x00000000E0020000L});
    public static final BitSet FOLLOW_17_in_ruleForeignModelMdsl2012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2029 = new BitSet(new long[]{0x00000000E0020000L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2057 = new BitSet(new long[]{0x000000401D000000L});
    public static final BitSet FOLLOW_24_in_ruleForeignModelMdsl2070 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForeignModelMdsl2082 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2103 = new BitSet(new long[]{0x000000401C000000L});
    public static final BitSet FOLLOW_26_in_ruleForeignModelMdsl2118 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForeignModelMdsl2130 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2151 = new BitSet(new long[]{0x0000004018000000L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2174 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleForeignModelMdsl2188 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleForeignModelMdsl2209 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleForeignModelMdsl2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelProviderMdsl2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleURIExtensionModelProviderMdsl2452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleURIModelProviderMdsl2557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleCustomModelProviderMdsl2662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2683 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleCustomModelProviderMdsl2696 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2713 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleCustomModelProviderMdsl2731 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleXtextLanguageDescriptorMdsl2840 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2857 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXtextLanguageDescriptorMdsl2874 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2891 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2908 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2925 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2942 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference3000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageReference3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleXtextLanguageReference3047 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageReference3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOCLCustomLibraryMdsl_in_entryRuleOCLCustomLibraryMdsl3103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOCLCustomLibraryMdsl3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOCLCustomLibraryMdsl3150 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOCLCustomLibraryMdsl3162 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOCLCustomLibraryMdsl3174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3191 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleOCLCustomLibraryMdsl3208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleOCLCustomLibraryMdsl3229 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleOCLCustomLibraryMdsl3242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3259 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOCLCustomLibraryMdsl3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleQueryEvaluatorMdsl3361 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryEvaluatorMdsl3373 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQueryEvaluatorMdsl3385 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3402 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleQueryEvaluatorMdsl3419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3436 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleQueryEvaluatorMdsl3453 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleQueryEvaluatorMdsl3465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3486 = new BitSet(new long[]{0x0000300010020000L});
    public static final BitSet FOLLOW_44_in_ruleQueryEvaluatorMdsl3499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3520 = new BitSet(new long[]{0x0000200210020000L});
    public static final BitSet FOLLOW_33_in_ruleQueryEvaluatorMdsl3533 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3554 = new BitSet(new long[]{0x0000200210020000L});
    public static final BitSet FOLLOW_45_in_ruleQueryEvaluatorMdsl3571 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3592 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleQueryEvaluatorMdsl3607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3624 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryEvaluatorMdsl3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_entryRuleWidgetType3679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetType3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleWidgetType3726 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleWidgetType3738 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleWidgetType3750 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetType3767 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleWidgetType3784 = new BitSet(new long[]{0x0000000000000000L,0x07FF000000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3805 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetType3817 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3834 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleWidgetType3851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3872 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleWidgetType3885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3902 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleWidgetType3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl3957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUITabMdsl3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUITabMdsl4004 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleUITabMdsl4016 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUITabMdsl4028 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleUITabMdsl4040 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUITabMdsl4057 = new BitSet(new long[]{0x0020000000002000L});
    public static final BitSet FOLLOW_53_in_ruleUITabMdsl4080 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUITabMdsl4106 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleUITabMdsl4127 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleUITabMdsl4140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUITabMdsl4157 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleUITabMdsl4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl4212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerMdsl4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleLayerMdsl4259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLayerMdsl4276 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4293 = new BitSet(new long[]{0x0020000000002000L});
    public static final BitSet FOLLOW_53_in_ruleLayerMdsl4311 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLayerMdsl4337 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4358 = new BitSet(new long[]{0x0080000010020000L});
    public static final BitSet FOLLOW_17_in_ruleLayerMdsl4371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLayerMdsl4388 = new BitSet(new long[]{0x0080000010000000L});
    public static final BitSet FOLLOW_55_in_ruleLayerMdsl4408 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleLayerMdsl4420 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4432 = new BitSet(new long[]{0x0040000010000000L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4453 = new BitSet(new long[]{0x0040000010000000L});
    public static final BitSet FOLLOW_28_in_ruleLayerMdsl4466 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleLayerMdsl4480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleTypeConfigurationMdsl4569 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleTypeConfigurationMdsl4595 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4612 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_59_in_ruleTypeConfigurationMdsl4630 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4650 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTypeConfigurationMdsl4664 = new BitSet(new long[]{0x7020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleTypeConfigurationMdsl4683 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleTypeConfigurationMdsl4709 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4730 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleTypeConfigurationMdsl4751 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4784 = new BitSet(new long[]{0x4000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTypeConfigurationMdsl4797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4817 = new BitSet(new long[]{0x4000000200000000L});
    public static final BitSet FOLLOW_62_in_ruleTypeConfigurationMdsl4833 = new BitSet(new long[]{0x8000000010000000L,0x0000000000000011L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4854 = new BitSet(new long[]{0x8000000010000000L,0x0000000000000011L});
    public static final BitSet FOLLOW_63_in_ruleTypeConfigurationMdsl4874 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4907 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_ruleTypeConfigurationMdsl4922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement4958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement5015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement5042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl5077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl5087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleIncludeTemplateElementMdsl5124 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleIncludeTemplateElementMdsl5158 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleIncludeTemplateElementMdsl5190 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl5211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueConverter_in_entryRuleValueConverter5247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueConverter5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleQueryBasedValueConverter5413 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5526 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleBasicTypeValueConverter5539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleWidgetConfigurationMdsl5646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5663 = new BitSet(new long[]{0x0020000000022000L,0x0000000000000060L});
    public static final BitSet FOLLOW_17_in_ruleWidgetConfigurationMdsl5681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5698 = new BitSet(new long[]{0x0020000000002000L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_ruleWidgetConfigurationMdsl5718 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5738 = new BitSet(new long[]{0x0020000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleWidgetConfigurationMdsl5753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5773 = new BitSet(new long[]{0x0020000200002000L});
    public static final BitSet FOLLOW_33_in_ruleWidgetConfigurationMdsl5786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5806 = new BitSet(new long[]{0x0020000200002000L});
    public static final BitSet FOLLOW_53_in_ruleWidgetConfigurationMdsl5828 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetConfigurationMdsl5854 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleWidgetConfigurationMdsl5887 = new BitSet(new long[]{0x0000000000000000L,0x07FF000000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5908 = new BitSet(new long[]{0x0020004002000002L,0x000000000003FF04L});
    public static final BitSet FOLLOW_25_in_ruleWidgetConfigurationMdsl5921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5941 = new BitSet(new long[]{0x0020004000000002L,0x000000000003FF04L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl5964 = new BitSet(new long[]{0x0020000000000002L,0x000000000003FF04L});
    public static final BitSet FOLLOW_72_in_ruleWidgetConfigurationMdsl5979 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_73_in_ruleWidgetConfigurationMdsl5997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl6018 = new BitSet(new long[]{0x0020000000000002L,0x000000000003FC04L});
    public static final BitSet FOLLOW_74_in_ruleWidgetConfigurationMdsl6078 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6099 = new BitSet(new long[]{0x0020000000000002L,0x000000000003FC04L});
    public static final BitSet FOLLOW_75_in_ruleWidgetConfigurationMdsl6167 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6188 = new BitSet(new long[]{0x0020000000000002L,0x000000000003FC04L});
    public static final BitSet FOLLOW_66_in_ruleWidgetConfigurationMdsl6242 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6263 = new BitSet(new long[]{0x0020000000000002L,0x000000000003F000L});
    public static final BitSet FOLLOW_76_in_ruleWidgetConfigurationMdsl6278 = new BitSet(new long[]{0x0000000000000000L,0x0000FC0000000008L});
    public static final BitSet FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6299 = new BitSet(new long[]{0x0020000000000002L,0x000000000003E000L});
    public static final BitSet FOLLOW_77_in_ruleWidgetConfigurationMdsl6314 = new BitSet(new long[]{0x0020000000000002L,0x000000000007C000L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6335 = new BitSet(new long[]{0x0020000000000002L,0x000000000007C000L});
    public static final BitSet FOLLOW_53_in_ruleWidgetConfigurationMdsl6357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleWidgetConfigurationMdsl6383 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6404 = new BitSet(new long[]{0x0020000000000002L,0x0000000000038000L});
    public static final BitSet FOLLOW_79_in_ruleWidgetConfigurationMdsl6419 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6440 = new BitSet(new long[]{0x0020000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_53_in_ruleWidgetConfigurationMdsl6461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleWidgetConfigurationMdsl6487 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6508 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleWidgetConfigurationMdsl6523 = new BitSet(new long[]{0x0000000000000020L,0x3800000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6544 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleWidgetConfigurationMdsl6557 = new BitSet(new long[]{0x0000000000000020L,0x3800000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6578 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidatorMdsl6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleValidatorMdsl6665 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6686 = new BitSet(new long[]{0x0020000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_53_in_ruleValidatorMdsl6704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_ruleValidatorMdsl6730 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand6787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_ruleCommand6871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDeclaration6916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleCommandDeclaration6953 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDeclaration6970 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCommandDeclaration6987 = new BitSet(new long[]{0x0000000000022000L,0x3800000000000000L});
    public static final BitSet FOLLOW_13_in_ruleCommandDeclaration7000 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration7017 = new BitSet(new long[]{0x0000000000020000L,0x3800000000000000L});
    public static final BitSet FOLLOW_17_in_ruleCommandDeclaration7037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration7054 = new BitSet(new long[]{0x0000000000000000L,0x3800000000000000L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration7082 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCommandDeclaration7094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl7130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl7140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl7186 = new BitSet(new long[]{0x0020000000000010L,0x0000020000600000L});
    public static final BitSet FOLLOW_53_in_ruleCommandDefinitionMdsl7205 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_85_in_ruleCommandDefinitionMdsl7255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleCommandDefinitionMdsl7289 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7310 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_87_in_ruleCommandDefinitionMdsl7323 = new BitSet(new long[]{0x0000000000000002L,0x0000000019000000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7344 = new BitSet(new long[]{0x0000000000000002L,0x0000000019000000L});
    public static final BitSet FOLLOW_88_in_ruleCommandDefinitionMdsl7360 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7381 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandRefMdsl7430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandRefMdsl7475 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ruleCommandRefMdsl7488 = new BitSet(new long[]{0x0020000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_53_in_ruleCommandRefMdsl7506 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7541 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleCommandRefMdsl7553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUICommandMdsl7601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisplayViewUICommand7747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleDisplayViewUICommand7784 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleDisplayViewUICommand7797 = new BitSet(new long[]{0x0000000000000030L,0x000002A700000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadViewUICommand7866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleReloadViewUICommand7912 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ruleReloadViewUICommand7924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand7960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand7970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleReloadWidgetsUICommand8007 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ruleReloadWidgetsUICommand8019 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand8039 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage8076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryUsage8086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryUsage8133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_ruleQueryUsage8160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_entryRuleQuery8195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQuery8205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_ruleQuery8279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDeclaration8324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleQueryDeclaration8361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDeclaration8378 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryDeclaration8395 = new BitSet(new long[]{0x0000000000022010L,0x0000022700000000L});
    public static final BitSet FOLLOW_13_in_ruleQueryDeclaration8408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8425 = new BitSet(new long[]{0x0000000000020010L,0x0000022700000000L});
    public static final BitSet FOLLOW_17_in_ruleQueryDeclaration8445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8462 = new BitSet(new long[]{0x0000000000000010L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8490 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryDeclaration8502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleQueryDefinitionMdsl8586 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8606 = new BitSet(new long[]{0x0000000000000010L,0x0000022700000000L});
    public static final BitSet FOLLOW_97_in_ruleQueryDefinitionMdsl8621 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8641 = new BitSet(new long[]{0x0000000000000010L,0x0000022700000000L});
    public static final BitSet FOLLOW_98_in_ruleQueryDefinitionMdsl8656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8673 = new BitSet(new long[]{0x0000000000000010L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8702 = new BitSet(new long[]{0x0000000002000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8729 = new BitSet(new long[]{0x0000000002000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_25_in_ruleQueryDefinitionMdsl8743 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8763 = new BitSet(new long[]{0x0000000000000002L,0x0000001800000000L});
    public static final BitSet FOLLOW_99_in_ruleQueryDefinitionMdsl8778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8799 = new BitSet(new long[]{0x0000000200000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_33_in_ruleQueryDefinitionMdsl8812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8833 = new BitSet(new long[]{0x0000000200000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_ruleQueryDefinitionMdsl8850 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryFragment8919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment8966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleQueryFragment8993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment9028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralQueryFragment9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment9079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBody_in_entryRuleQueryBody9119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBody9129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody9175 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleQueryBody9188 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody9209 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryRefMdsl9257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryRefMdsl9301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleExternalQueryCallMdsl9383 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9403 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_ruleExternalQueryCallMdsl9415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_entryRuleQueryChain9451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryChain9461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleQueryChain9498 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryChain9510 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9531 = new BitSet(new long[]{0x0000000210000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_33_in_ruleQueryChain9545 = new BitSet(new long[]{0x0000000000000030L,0x0000022700000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9566 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryChain9580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExpr9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9672 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleFormatExpr9685 = new BitSet(new long[]{0x0000000000000010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9706 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExprFragment9754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_entryRuleTextMacro9954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacro9964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleTextMacro10001 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacro10018 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTextMacro10035 = new BitSet(new long[]{0x0000000000022000L,0x0000000000000004L});
    public static final BitSet FOLLOW_13_in_ruleTextMacro10048 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10065 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000004L});
    public static final BitSet FOLLOW_17_in_ruleTextMacro10085 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleTextMacro10121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10138 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTextMacro10155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef10191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacroRef10201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleTextMacroRef10238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacroRef10258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleWIDGET_CATEGORY_MDSL10438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleWIDGET_CATEGORY_MDSL10455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleWIDGET_CATEGORY_MDSL10608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleCOMMAND_CATEGORY_MDSL10653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleCOMMAND_CATEGORY_MDSL10670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleCOMMAND_CATEGORY_MDSL10687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleQUERY_OPTIMISATION_LEVEL10732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleQUERY_OPTIMISATION_LEVEL10749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleQUERY_OPTIMISATION_LEVEL10766 = new BitSet(new long[]{0x0000000000000002L});

}

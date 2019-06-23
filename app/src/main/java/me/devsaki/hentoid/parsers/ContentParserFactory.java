package me.devsaki.hentoid.parsers;

import me.devsaki.hentoid.database.domains.Content;
import me.devsaki.hentoid.enums.Site;

public class ContentParserFactory {

    private static final ContentParserFactory mInstance = new ContentParserFactory();

    private ContentParserFactory() {
    }

    public static ContentParserFactory getInstance() {
        return mInstance;
    }

    public ContentParser getParser(Content content) {
        return (null == content) ? new DummyParser() : getParser(content.getSite());
    }

    private ContentParser getParser(Site site) {
        switch (site) {
            case ASMHENTAI:
            case ASMHENTAI_COMICS:
                return new ASMHentaiParser();
            case HENTAICAFE:
                return new HentaiCafeParser();
            case HITOMI:
                return new HitomiParser();
            case TSUMINO:
                return new TsuminoParser();
            case PURURIN:
                return new PururinParser();
            case EHENTAI:
                return new EHentaiParser();
            case FAKKU2:
                return new FakkuParser();
            case NEXUS:
                return new NexusParser();
            default:
                return new DummyParser();
        }
    }
}
